package com.kkkitsch.coolalbum.service.imp;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kkkitsch.coolalbum.common.MD5;
import com.kkkitsch.coolalbum.common.TimeFormat;
import com.kkkitsch.coolalbum.dao.TMemberMapper;
import com.kkkitsch.coolalbum.entity.TMember;
import com.kkkitsch.coolalbum.entity.TMemberExample;
import com.kkkitsch.coolalbum.entity.TMemberExample.Criteria;
import com.kkkitsch.coolalbum.service.TMemberService;
import com.kkkitsch.coolalbum.util.MyMsg;

@Service
public class TMemberServiceImpl implements TMemberService {

	@Autowired
	TMemberMapper tMemberMapper;

	/**
	 * 会员登录
	 */
	@Override
	public MyMsg<TMember> memberLogin(TMember member) {

		// 封装查询条件
		TMemberExample example = new TMemberExample();
		Criteria criteria = example.createCriteria();
		criteria.andMAccountnameEqualTo(member.getmAccountname());
		criteria.andMPasswordEqualTo(MD5.md5(member.getmAccountname(), member.getmPassword()));
		// 查询
		List<TMember> list = tMemberMapper.selectByExample(example);

		System.out.println("查询结果：" + list);
		System.out.println("list.isEmpty()：" + list.isEmpty());
		System.out.println("list==null：" + list == null);

		// 如果有查询结果返回true，否则返回false
		if (!list.isEmpty() && list.size() == 1) {
			return MyMsg.success("登录成功", list.get(0), null);
		} else {
			return MyMsg.fail("登录失败，用户名或密码错误", member, null);
		}
	}

	/**
	 * 会员注册
	 */
	@Override
	public MyMsg<TMember> memberRegister(TMember member, String mRePassword) {

		// 后端校验
		// 如果两次密码不一致
		if (!member.getmPassword().equals(mRePassword)) {
			return MyMsg.fail("两次密码不一致", member, null);
		}
		// 如果用户名长度不够或密码长度不够
		if (member.getmAccountname().length() < 3 || member.getmPassword().length() < 6 || mRePassword.length() < 6) {
			return MyMsg.fail("如果用户名长度不够或密码长度不够", member, null);
		}

		Pattern r = Pattern.compile("\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\.)+[A-Za-z]{2,14}");
		Matcher m = r.matcher(member.getmEmail());
		// 如果邮箱格式不正确
		if (!m.matches()) {
			return MyMsg.fail("邮箱格式不正确", member, null);
		}

		Pattern patternPhone = Pattern.compile("0?(13|14|15|18|17)[0-9]{9}");
		Matcher phoneMatcher = patternPhone.matcher(member.getmPhone());
		// 如果手机号格式不正确
		if (!phoneMatcher.matches()) {
			return MyMsg.fail("手机号格式不正确", member, null);
		}

		// 设置默认信息
		// 设置昵称默认和用户名相同
		member.setmNickname(member.getmAccountname());
		member.setmCreatetime(TimeFormat.timeFormat(new Date()));
		member.setmSignature("");
		// 加密密码
		member.setmPassword(MD5.md5(member.getmAccountname(), member.getmPassword()));

		// 注册
		int affectNum = -1;

		try {
			affectNum = tMemberMapper.insertSelective(member);
			if (affectNum == 1) {
				return MyMsg.success("注册成功", member, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return MyMsg.fail("注册失败，有可能是用户名或邮箱或手机号有冲突，请修改重试", member, null);
		}
		return MyMsg.fail("注册失败，发生未知错误", member, null);
	}

	/**
	 * 更新会员信息
	 */
	@Override
	public boolean updateMyInfo(TMember member) {
		int affectNum = -1;
		try {
			affectNum = tMemberMapper.updateByPrimaryKeySelective(member);
			return affectNum == 1 ? true : false;
		} catch (Exception e) {
			return false;
		}
	}
}
