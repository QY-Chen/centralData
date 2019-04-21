package com.imec.central.aop;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.imec.central.components.admin.pojo.User;
/**
 * aop切面类，记录用户操作详情
 */
@Component
@Aspect
public class UserOperationAspect {
	/**
	 * 文件存放的位置
	 */
	private final static String PATH = "G:/ideaIC/workspace/central/log/";
	/**
	 * 生成用户操作日志
	 * @param jp 
	 * @param session
	 * @return
	 * @throws Throwable 
	 */
	@Around("bean(*Service)")
	public Object test(ProceedingJoinPoint jp,HttpSession session) throws Throwable{		
		User user = (User)session.getAttribute("User");
		String filePath = PATH + user.getName();		
		File dir = new File(filePath);
		if(!dir.exists()){
			dir.mkdir();
		}		
		String fileName = filePath +"/"+user.getName()+".txt";
		File file = new File(fileName);
		if(!file.exists()){
			file.createNewFile();
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		PrintWriter pw = new PrintWriter(
				new OutputStreamWriter(
						new FileOutputStream(file,true),"UTF-8"));
		String data = user.getName()+":"+sdf.format(new Date())+":"+jp.getSignature();//jp可以直接获取方法签名
		pw.println(data);
		pw.flush();
		pw.close();
		Object val = jp.proceed();		
		return val;
	}
	
	
}
