package org.bran.branroom.dto;

import static org.junit.Assert.*;

import org.bran.branroom.base.BaseTest;
import org.junit.Test;

public class ResultTest extends BaseTest {

	@Test
	public void testToJson() {
		Result result=new Result();
		result.setStatus(Result.SUCCESS);
		System.out.println(result.toJson());
	}

}
