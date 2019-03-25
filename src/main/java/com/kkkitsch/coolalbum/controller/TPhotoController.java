package com.kkkitsch.coolalbum.controller;

import static com.kkkitsch.coolalbum.common.MyConstant.UPLOAD_ERROR_MSG;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.kkkitsch.coolalbum.common.MyAcctAndId;
import com.kkkitsch.coolalbum.common.MyConstant;
import com.kkkitsch.coolalbum.common.TimeFormat;
import com.kkkitsch.coolalbum.entity.TMember;
import com.kkkitsch.coolalbum.entity.TPhoto;
import com.kkkitsch.coolalbum.service.TPhotoService;
import com.kkkitsch.coolalbum.util.MyMsg;

@Controller
@RequestMapping("/photo")
public class TPhotoController {

	@Autowired
	TPhotoService photoServiceImpl;

	/**
	 * 上传图片
	 */
	@RequestMapping("/upload")
	public String upload(@RequestParam("upFile") MultipartFile[] file, TPhoto photo, HttpSession session, Model model) {
		System.out.println("原始数据：" + photo);
		// 获取目录的真实路径
		String realPath = session.getServletContext().getRealPath("/image");
		// 默认情况下，即使没有选择文件，MultipartFile数组的长度也不为空，而是存在一个空文件，你必须遍历判断其中的文件是否为空
		for (MultipartFile cur_file : file) {
			// 格式化Date对象
			String dateFormat = TimeFormat.timeFormat(new Date());
			// 防止用户名重复，重新改变文件名
			String newFilename = "";
			// 如果文件不为空
			if (!cur_file.isEmpty()) {
				newFilename = cur_file.getOriginalFilename().substring(0, cur_file.getOriginalFilename().length() - 4)
						+ "_"
						+ (dateFormat.toString().replace(" ", "_").replace(":", "_")
								+ cur_file.getOriginalFilename().substring(cur_file.getOriginalFilename().length() - 4,
										cur_file.getOriginalFilename().length()));

				// 如果不是图片
				if (!cur_file.getContentType().contains("image")) {
					model.addAttribute(UPLOAD_ERROR_MSG, MyMsg.fail("上传失败，不是一个图片", photo, null));
					return "member_home";
				}
				// 如果图片超过了20M
				if (20 * 1024 * 1024 < cur_file.getSize()) {
					model.addAttribute(UPLOAD_ERROR_MSG, MyMsg.fail("上传失败，请上传小于20M的图片", photo, null));
					return "member_home";
				}
			} else {
				// 文件为空
				model.addAttribute(UPLOAD_ERROR_MSG, MyMsg.fail("请选择图片！", null, null));
				return "member_home";
			}
			try {
				// 保存到本地
				cur_file.transferTo(new File(realPath + "/" + newFilename));
			} catch (IOException e) {
				System.out.println("传输失败");
			}
			String netUrl = "image/" + newFilename;
			// 设置图片的默认属性
			photo.setpCreatetime(new Date());
			photo.setpLikenum(0);
			photo.setpUrl(netUrl);
			photo.setpName(newFilename);
			photo.setpModitytime(new Date());
			photo.setpMemberId(((TMember) session.getAttribute(MyConstant.CUR_MEMBER)).getmId());
			System.out.println("设置过属性后的photo=" + photo);
			// 保存
			MyMsg<TPhoto> myMsg = photoServiceImpl.uploadFile(photo);
			System.out.println("myMsg.getContent() == photo:" + (myMsg.getContent() == photo));
			System.out.println("上传完成之后，得到了自增主键的photo=" + photo);
			// 去除自增主键，直接操作photo即可，因为传递的是各个引用，photo==myMsg.getContent();
			photo.setpId(null);
			System.out.println("上传完成之后，去除了自增主键的的photo=" + photo);
			// 判断是否保存成功！
			if (myMsg.getCode() != 1) {
				model.addAttribute(UPLOAD_ERROR_MSG, myMsg.getMsg());
			}
		}
		// 防止重复提交表单
		return "redirect:/member_home.html";
	}

	/**
	 * 获取所有图片
	 */
	@RequestMapping("/getAllPhoto")
	@ResponseBody
	public MyMsg<List<TPhoto>> getAllPhoto(HttpSession session) {
		return photoServiceImpl.getAllPhoto(MyAcctAndId.getMyId(session));
	}

	/**
	 * 指定图片信息
	 */
	@RequestMapping("/getDelicatedPhoto")
	@ResponseBody
	public MyMsg<TPhoto> getDelicatedPhoto(String pId) {
		return photoServiceImpl.getDelicatedPhoto(pId);
	}

	/**
	 * 图片点赞
	 */
	@RequestMapping("/clicklike")
	@ResponseBody
	public MyMsg<TPhoto> ifClickLike(TPhoto photo, HttpSession session) {
		return photoServiceImpl.updateClickNum(photo, MyAcctAndId.getMyId(session));
	}

	/**
	 * 图片删除
	 */
	@RequestMapping("/singledelete")
	@ResponseBody
	public MyMsg<TPhoto> singleDelete(String pId) {
		return photoServiceImpl.singleDelete(pId);
	}
}
