/**
 * BLOGABC system 1.0
 * 
 * This is an open source system for studying spring framework and hibernate.
 * You can use it anywhere and you can ask your question or update your good idea. 
 * author: erichan1979@gmail.com
 * date: 2009-3-30
 */
package blogabc.test;

import junit.framework.TestCase;
import blogabc.business.ClassifyBusiness;
import blogabc.dao.ClassifyDAO;
import blogabc.entity.Classify;
import blogabc.home.BlogABCException;

public class ClassifyTest extends TestCase {

	ClassifyBusiness cb;
	ClassifyDAO classifyDao;

	public void testCRUD() throws BlogABCException {
		classifyDao = new ClassifyDAO();
		cb=new ClassifyBusiness();
		cb.setClassifyDao(classifyDao);
		Classify classify = new Classify();
		classify.setName("test");
		
		Long cId = cb.createClassify(classify);
		
		assertNotNull(cId);

		classify = cb.getClassify(cId);
		assertNotNull(classify);

		boolean isModified = cb.modifyClassify(classify);
		assertTrue(isModified);

		boolean isRemoved = cb.removeClassify(classify);
		assertTrue(isRemoved);
	}
}
