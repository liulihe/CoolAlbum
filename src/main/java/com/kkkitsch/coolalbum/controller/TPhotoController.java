package com.kkkitsch.coolalbum.controller;

import static com.kkkitsch.coolalbum.common.MyConstant.UPLOAD_ERROR_MSG;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
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

import com.kkkitsch.coolalbum.common.MyConstant;
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
	 * 
	 * @param file
	 *            需要上传的文件
	 * @param photo
	 *            实体映射
	 * @param session
	 * @param model
	 *            模型数据
	 * @return 逻辑视图名
	 */
	@RequestMapping("/upload")
	public String upload(@RequestParam("upFile") MultipartFile file, TPhoto photo, HttpSession session, Model model) {

		System.out.println("原始数据：" + photo);

		// 获取目录的真实路径
		String realPath = session.getServletContext().getRealPath("/image");
		System.out.println("image在服务器下的真实路径：" + realPath);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd HH:mm:ss");
		// 格式化Date对象
		String dateFormat = sdf.format(new Date());

		// 防止用户名重复，重新改变文件名
		String newFilename = "";

		// 如果文件不为空
		if (!file.isEmpty()) {

			newFilename = file.getOriginalFilename().substring(0, file.getOriginalFilename().length() - 4) + "_"
					+ (dateFormat.toString().replace(" ", "_").replace(":", "_"));
			System.out.println("文件的原始名称" + file.getOriginalFilename());
			System.out.println("文件的新名称" + newFilename);

			// 如果不是图片
			if (!file.getContentType().contains("image")) {
				model.addAttribute(UPLOAD_ERROR_MSG, MyMsg.fail("上传失败，不是一个图片", photo, null));
				return "member_home";
			}
			// 如果图片超过了20M
			if (20 * 1024 * 1024 < file.getSize()) {
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
			file.transferTo(new File(realPath + "/" + newFilename));
		} catch (IOException e) {
			System.out.println("传输失败");
		}

		String netUrl = "image/" + newFilename;
		System.out.println("netUrl=" + netUrl);

		// 设置图片的默认属性
		photo.setpCreatetime(new Date());
		photo.setpLikenum(0);
		photo.setpUrl(netUrl);
		// 如果给图片起了名字，那就用指定的名称，否则用默认的名称
		if ("".equals(photo.getpName().trim())) {
			photo.setpName(file.getOriginalFilename());
		}
		photo.setpModitytime(new Date());
		photo.setpMemberId(((TMember) session.getAttribute(MyConstant.CUR_MEMBER)).getmId());

		System.out.println("设置过属性后的photo=" + photo);

		// 保存
		MyMsg<TPhoto> myMsg = photoServiceImpl.uploadFile(photo);

		// 判断是否保存成功！
		if (myMsg.getCode() != 1) {
			model.addAttribute(UPLOAD_ERROR_MSG, myMsg.getMsg());
		}
		// 防止重复提交表单
		return "redirect:/member_home.html";
	}

	/**
	 * @param session
	 * @return 图片封装信息
	 */
	@RequestMapping("/getAllPhoto")
	@ResponseBody
	public MyMsg<List<TPhoto>> getAllPhoto(HttpSession session) {
		// 获取当前用户id
		Integer mId = ((TMember) session.getAttribute(MyConstant.CUR_MEMBER)).getmId();
		List<TPhoto> photoList = photoServiceImpl.getAllPhoto(mId);
		if (!photoList.isEmpty()) {
			return MyMsg.success("查询成功", photoList, null);
		} else {
			return MyMsg.fail("查询无果", null, null);
		}
	}

	/**
	 * 点击点赞
	 */
	@RequestMapping("/clicklike")
	@ResponseBody
	public MyMsg<TPhoto> ifClickLike(TPhoto photo, HttpSession session) {

		// 获取当前用户id
		Integer mId = ((TMember) session.getAttribute(MyConstant.CUR_MEMBER)).getmId();
		photo.setpMemberId(mId);

		System.out.println("图片信息：" + photo);

		// 更新点赞数
		// 如果不为空
		if (photo.getpMemberId() != null) {
			boolean flag = photoServiceImpl.updateClickNum(photo);
			// 点赞成功
			if (flag) {
				return MyMsg.success("点赞成功", null, null);
			} else {
				// 点赞成功
				return MyMsg.fail("点赞失败", null, null);
			}
		} else {
			// 未登录
			return MyMsg.fail("没有登录，请登录后操作", null, null);
		}
	}

	@RequestMapping("/singledelete")
	@ResponseBody
	public MyMsg<TPhoto> singleDelete(String pId) {

		boolean flag = photoServiceImpl.singleDelete(pId);
		if (flag) {
			return MyMsg.success("删除成功", null, null);
		} else {
			return MyMsg.fail("删除失败", null, null);
		}
	}

}
