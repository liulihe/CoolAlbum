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
	 * 
	 * @param file 需要上传的文件
	 * @param photo 实体映射
	 * @param session
	 * @param model 模型数据
	 * @return 逻辑视图名
	 * 
	 * @notice 1.处理器的形参
	 *         用于接收表单元素所提交参数的处理器方法的形参类型为MultipartFile[]数组，并且必须使用注解@RequestParam修饰
	 *         为什么单个文件上传时不需要@RequestParam注解修饰，而上传多个文件时就需要用@RequestParam修饰呢？
	 *         因为在上传多个文件时，每个表单中的文件对象均会被spring
	 *         mvc框架将其转换为MultipartFile类型，这个与单个文件上传一样，不需要@RequestParam修饰。
	 *         但是上传多个文件时，处理器方法需要的不是MultipartFile类型，而是MultipartFile[]数组类型，默认情况下，框架会将表单中的表单元素一个个转换为文件对象，
	 *         但并不会将多个文件对象创建为一个数组对象。此时就需要用@RequestParam注解修饰这个数组参数，需要框架调用相应的转换器将请求参数转换为方法参数类型。
	 *         所以上传多个文件，处理器方法的MultipartFile[]数组必须使用@RequestParam注解修饰。 2.未选择上传文件
	 *         即使没有选择任何文件，MultipartFile[]数组也不为null。不仅不为null，其length值也大于0.
	 *         因为系统会为每个file表单元素创建一个file对象。只不过没有选择上传文件的这个file将不会被赋予真正的文件，只是一个为empty的File。所以对于没有选择任何要上传的文件
	 *         的情况的处理，只能逐个对文件表单元素进行判断，判断文件是否为empty。
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
	 * @param session
	 * @return 图片封装信息
	 */
	@RequestMapping("/getAllPhoto")
	@ResponseBody
	public MyMsg<List<TPhoto>> getAllPhoto(HttpSession session) {
		List<TPhoto> photoList = photoServiceImpl.getAllPhoto(MyAcctAndId.getMyId(session));
		if (!photoList.isEmpty()) {
			return MyMsg.success("查询成功", photoList, null);
		} else {
			return MyMsg.fail("查询无果", null, null);
		}
	}
	
	/**
	 * @param session
	 * @return 图片封装信息
	 * 获取指定图片
	 */
	@RequestMapping("/getDelicatedPhoto")
	@ResponseBody
	public MyMsg<TPhoto> getDelicatedPhoto(String pId) {
		TPhoto photo = photoServiceImpl.getDelicatedPhoto(pId);
		if (photo!=null) {
			return MyMsg.success("查询成功", photo, null);
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
		// 更新点赞数
		boolean flag = photoServiceImpl.updateClickNum(photo,MyAcctAndId.getMyId(session));
		if (flag) {
			return MyMsg.success("点赞成功", null, null);
		} else {
			return MyMsg.fail("点赞失败", null, null);
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
