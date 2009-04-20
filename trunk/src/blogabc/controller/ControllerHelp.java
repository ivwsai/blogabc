/**
 * BLOGABC system 1.0
 * 
 * This is an open source system for studying spring framework and hibernate.
 * You can use it anywhere and you can ask your question or update your good idea. 
 * author: ericHan1979@gmail.com
 * date: 2009-3-30
 */
package blogabc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import blogabc.entity.User;

public class ControllerHelp {

	public static Map<String, String> user2model(HttpServletRequest request, User user) {
		Map<String, String> model = new HashMap<String, String>();
		model.put("user", user.getName());
		if (user.getPhotoUrl() == null) {
		} else if (user.getPhotoUrl().length() > 0) {
			String path = request.getRequestURL().toString();
			try{
			path = path.substring(0, path.indexOf("user"));
			}catch(Exception e){
				path = "http://localhost:8080/blogabc/";
			}
			path += user.getPhotoUrl();
			model.put("url", path);
		}

		model.put("userName", user.getFirstName() + " " + user.getLastName());
		model.put("userId", user.getId()+"");
		model.put("mobile", user.getPhone());
		model.put("email", user.getEmail());
		model.put("lastName", user.getLastName());
		model.put("firstName", user.getFirstName());
		model.put("point", user.getPoint() + "");
		model.put("des", user.getDescription());
		
		Long sessionId=(Long) request.getSession().getAttribute("userId");		
		boolean isOwn;
		if(sessionId==null){
			isOwn=false;
		}else
			isOwn=sessionId.equals(user.getId());
		model.put("isOwn", isOwn+"");
		return model;
	}
}
