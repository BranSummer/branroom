package org.bran.branroom.service;

import org.bran.branroom.base.BaseTest;
import org.bran.branroom.dto.Result;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BlogServiceTest extends BaseTest {
	
	@Autowired
	private BlogService blogService;

	@Test
	public void testgetBlogsByAuthorByPage() {
		Result r=blogService.getBlogsByAuthorByPage("admin", 0, 4);
		System.out.println(r.toJson());
	}

}
