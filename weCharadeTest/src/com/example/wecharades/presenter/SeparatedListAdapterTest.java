package com.example.wecharades.presenter;

import org.junit.*;
import static org.junit.Assert.*;
import com.example.wecharades.views.CaptureVideoActivity;
import android.content.Context;
import android.accounts.AccountAuthenticatorActivity;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.view.View;
import android.widget.AbsoluteLayout;

/**
 * The class <code>SeparatedListAdapterTest</code> contains tests for the class <code>{@link SeparatedListAdapter}</code>.
 *
 * @generatedBy CodePro at 2013-05-29 09:37
 * @author felixkarlsson
 * @version $Revision: 1.0 $
 */
public class SeparatedListAdapterTest {
	/**
	 * Run the SeparatedListAdapter(Context) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testSeparatedListAdapter_1()
		throws Exception {
		Context context = new CaptureVideoActivity();

		SeparatedListAdapter result = new SeparatedListAdapter(context);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
		assertNotNull(result);
	}

	/**
	 * Run the void addSection(String,Adapter) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testAddSection_1()
		throws Exception {
		SeparatedListAdapter fixture = new SeparatedListAdapter(new CaptureVideoActivity());
		String section = "";
		Adapter adapter = new SeparatedListAdapter(new CaptureVideoActivity());

		fixture.addSection(section, adapter);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
	}

	/**
	 * Run the boolean areAllItemsSelectable() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testAreAllItemsSelectable_1()
		throws Exception {
		SeparatedListAdapter fixture = new SeparatedListAdapter(new CaptureVideoActivity());

		boolean result = fixture.areAllItemsSelectable();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
		assertTrue(result);
	}

	/**
	 * Run the int getCount() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testGetCount_1()
		throws Exception {
		SeparatedListAdapter fixture = new SeparatedListAdapter(new CaptureVideoActivity());

		int result = fixture.getCount();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
		assertEquals(0, result);
	}

	/**
	 * Run the int getCount() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testGetCount_2()
		throws Exception {
		SeparatedListAdapter fixture = new SeparatedListAdapter(new CaptureVideoActivity());

		int result = fixture.getCount();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
		assertEquals(0, result);
	}

	/**
	 * Run the Object getItem(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testGetItem_1()
		throws Exception {
		SeparatedListAdapter fixture = new SeparatedListAdapter(new CaptureVideoActivity());
		int position = 1;

		Object result = fixture.getItem(position);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
		assertNotNull(result);
	}

	/**
	 * Run the Object getItem(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testGetItem_2()
		throws Exception {
		SeparatedListAdapter fixture = new SeparatedListAdapter(new CaptureVideoActivity());
		int position = 1;

		Object result = fixture.getItem(position);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
		assertNotNull(result);
	}

	/**
	 * Run the Object getItem(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testGetItem_3()
		throws Exception {
		SeparatedListAdapter fixture = new SeparatedListAdapter(new CaptureVideoActivity());
		int position = 1;

		Object result = fixture.getItem(position);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
		assertNotNull(result);
	}

	/**
	 * Run the Object getItem(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testGetItem_4()
		throws Exception {
		SeparatedListAdapter fixture = new SeparatedListAdapter(new CaptureVideoActivity());
		int position = 1;

		Object result = fixture.getItem(position);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
		assertNotNull(result);
	}

	/**
	 * Run the long getItemId(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testGetItemId_1()
		throws Exception {
		SeparatedListAdapter fixture = new SeparatedListAdapter(new CaptureVideoActivity());
		int position = 1;

		long result = fixture.getItemId(position);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
		assertEquals(0L, result);
	}

	/**
	 * Run the int getItemViewType(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testGetItemViewType_1()
		throws Exception {
		SeparatedListAdapter fixture = new SeparatedListAdapter(new CaptureVideoActivity());
		int position = 1;

		int result = fixture.getItemViewType(position);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
		assertEquals(0, result);
	}

	/**
	 * Run the int getItemViewType(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testGetItemViewType_2()
		throws Exception {
		SeparatedListAdapter fixture = new SeparatedListAdapter(new CaptureVideoActivity());
		int position = 1;

		int result = fixture.getItemViewType(position);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
		assertEquals(0, result);
	}

	/**
	 * Run the int getItemViewType(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testGetItemViewType_3()
		throws Exception {
		SeparatedListAdapter fixture = new SeparatedListAdapter(new CaptureVideoActivity());
		int position = 1;

		int result = fixture.getItemViewType(position);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
		assertEquals(0, result);
	}

	/**
	 * Run the int getItemViewType(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testGetItemViewType_4()
		throws Exception {
		SeparatedListAdapter fixture = new SeparatedListAdapter(new CaptureVideoActivity());
		int position = 1;

		int result = fixture.getItemViewType(position);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
		assertEquals(0, result);
	}

	/**
	 * Run the View getView(int,View,ViewGroup) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testGetView_1()
		throws Exception {
		SeparatedListAdapter fixture = new SeparatedListAdapter(new CaptureVideoActivity());
		int position = 1;
		View convertView = new View(new CaptureVideoActivity());
		ViewGroup parent = new AbsoluteLayout(new AccountAuthenticatorActivity());

		View result = fixture.getView(position, convertView, parent);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
		assertNotNull(result);
	}

	/**
	 * Run the View getView(int,View,ViewGroup) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testGetView_2()
		throws Exception {
		SeparatedListAdapter fixture = new SeparatedListAdapter(new CaptureVideoActivity());
		int position = 1;
		View convertView = new View(new CaptureVideoActivity());
		ViewGroup parent = new AbsoluteLayout(new AccountAuthenticatorActivity());

		View result = fixture.getView(position, convertView, parent);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
		assertNotNull(result);
	}

	/**
	 * Run the View getView(int,View,ViewGroup) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testGetView_3()
		throws Exception {
		SeparatedListAdapter fixture = new SeparatedListAdapter(new CaptureVideoActivity());
		int position = 1;
		View convertView = new View(new CaptureVideoActivity());
		ViewGroup parent = new AbsoluteLayout(new AccountAuthenticatorActivity());

		View result = fixture.getView(position, convertView, parent);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
		assertNotNull(result);
	}

	/**
	 * Run the View getView(int,View,ViewGroup) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testGetView_4()
		throws Exception {
		SeparatedListAdapter fixture = new SeparatedListAdapter(new CaptureVideoActivity());
		int position = 1;
		View convertView = new View(new CaptureVideoActivity());
		ViewGroup parent = new AbsoluteLayout(new AccountAuthenticatorActivity());

		View result = fixture.getView(position, convertView, parent);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
		assertNotNull(result);
	}

	/**
	 * Run the int getViewTypeCount() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testGetViewTypeCount_1()
		throws Exception {
		SeparatedListAdapter fixture = new SeparatedListAdapter(new CaptureVideoActivity());

		int result = fixture.getViewTypeCount();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
		assertEquals(0, result);
	}

	/**
	 * Run the int getViewTypeCount() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testGetViewTypeCount_2()
		throws Exception {
		SeparatedListAdapter fixture = new SeparatedListAdapter(new CaptureVideoActivity());

		int result = fixture.getViewTypeCount();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
		assertEquals(0, result);
	}

	/**
	 * Run the boolean isEnabled(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testIsEnabled_1()
		throws Exception {
		SeparatedListAdapter fixture = new SeparatedListAdapter(new CaptureVideoActivity());
		int position = 1;

		boolean result = fixture.isEnabled(position);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
		assertTrue(result);
	}

	/**
	 * Run the boolean isEnabled(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testIsEnabled_2()
		throws Exception {
		SeparatedListAdapter fixture = new SeparatedListAdapter(new CaptureVideoActivity());
		int position = 1;

		boolean result = fixture.isEnabled(position);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
		assertTrue(result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(SeparatedListAdapterTest.class);
	}
}