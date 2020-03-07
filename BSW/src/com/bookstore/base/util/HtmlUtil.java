
package com.bookstore.base.util;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

/*import com.qfund.ml.bean.MessageBean;
import com.qfund.ml.bean.ValidateError;*/
//import com.qfund.ml.conf.AppConstants;

public class HtmlUtil {
	private static String className = "HtmlUtil";
	private static final String CHECKBOXHGT ="<td height='24'><input type='checkbox' name='checkBox' value='";
	private static final String CHECKBOX ="<td><input type='checkbox' name='checkBox' value='";
	private static final String STRONG = "<strong>";
	private static final String STRONGTD = "</strong></td>";
	private static final String TDSTRONG = "</td><td><strong>";
	private static final String TR = "<tr>";
	private static final String ENDTR = "</tr>";
	private static final String VALUE = "' value='";
	private static final String METHODHTMLBLOCK = "getHtmlBlock";
	private static final String SELECT = "<select name=\"";
	private static final String OPTIONTAG = "<option value=\"";
	private static final String IDVAL = "id=\"";
	private static final String ENDOPTIONTAG = "</option>";
	private static final String OPTIONENDTAG = "\" value=\"\"></option>";
	private static final String ENDSELECT  = "</select>";
	private static final String OPTIONS = "<option value=\"\"></option>";
	private static final String SELECTED = "selected";
	private static final String SIZETAG = " size=\"";
	private static final String STYLE = "style=\"width: 150px;\"";
	private static final String OPTIONDEF = "<option id=\"defaultValue-";
	private static final String VALUETAG = "\" value=\"";
	private static final String ONCHANGE = "\" onchange=\"";
	private static final String ONCLICK = "\" onclick=\"";
	private static final String FALSE = "false";
	public static final String TD_CLO_OPN = "</td><td>";
	
	static public String customFormat(final String pattern, final double value) {
		final DecimalFormat myFormatter = new DecimalFormat(pattern);
		return myFormatter.format(value);
	}

	public static String getCheckBoxHtmlBlock(final ArrayList alResults,
			final String strChkBoxName) throws Exception {
		final String methodName = "getCheckBoxHtmlBlock";

		String strHtml = "";
		int j = 0;
		int w = 0;
		String[] strCheckBoxValues = {};
		String[] strCheckBoxNames = {};
		//LogTracer.writeDebugLog(className, methodName, "Start");
		try {
			if ((alResults != null) && (alResults.size() > 0)) {
				strCheckBoxValues = new String[alResults.size()];
				strCheckBoxNames = new String[alResults.size()];
				for (int i = 0; i < alResults.size(); i++) {
					final String[] tempValues = (String[]) alResults.get(i);
					strCheckBoxValues[w] = tempValues[0];
					strCheckBoxNames[w] = tempValues[1];
					if (w < strCheckBoxValues.length) {
						w++;
					}
				}
				for (int i = 0; i < strCheckBoxValues.length; i++) {
					if ((i % 2) == 0) {
						if (i < (strCheckBoxValues.length - 1)) {
							if ("Deny New".equals(strCheckBoxNames[i])) {
								strHtml = strHtml
										+ "<tr>"
										+ "<td height='24'><input type='checkbox' name='checkBox' value='"
										+ strCheckBoxValues[j]
										+ "' onClick='javascript:doProcess(this)' />"
										+ "<strong> "
										+ strCheckBoxNames[j]
										+ "</strong></td>"
										+ "<td><input type='checkbox' name='checkBox' value='"
										+ strCheckBoxValues[j + 1] + "' />"
										+ "<strong>" + strCheckBoxNames[j + 1]
										+ "</strong></td>" + "</tr>";
							} else if ("SMS Opt In".equals(strCheckBoxNames[i])) {
								strHtml = strHtml
										+ "<tr>"
										+ "<td height='24'><input type='checkbox' name='checkBox' value='"
										+ strCheckBoxValues[j]
										+ "' onClick='javascript:enableSMSDetails(this)' />"
										+ "<strong> "
										+ strCheckBoxNames[j]
										+ "</strong></td>"
										+ "<td><input type='checkbox' name='checkBox' value='"
										+ strCheckBoxValues[j + 1] + "' />"
										+ "<strong>" + strCheckBoxNames[j + 1]
										+ "</strong></td>" + "</tr>";
							} else {
								strHtml = strHtml
										+ "<tr>"
										+ "<td height='24'><input type='checkbox' name='checkBox' value='"
										+ strCheckBoxValues[j]
										+ "' />"
										+ "<strong> "
										+ strCheckBoxNames[j]
										+ "</strong></td>"
										+ "<td><input type='checkbox' name='checkBox' value='"
										+ strCheckBoxValues[j + 1] + "' />"
										+ "<strong>" + strCheckBoxNames[j + 1]
										+ "</strong></td>" + "</tr>";
							}
							j = j + 2;
							strHtml = strHtml + "\n";
							i = i + 1;
						}

					}
					if ((i == (strCheckBoxValues.length - 1))
							&& ((strCheckBoxValues.length % 2) != 0)) {
						strHtml = strHtml
								+ "\n<tr>"
								+ "<td height='24'><input type='checkbox' name='checkBox' value='"
								+ strCheckBoxValues[i] + "' />" + "<strong>"
								+ strCheckBoxNames[i] + "</strong></td>"
								+ "</tr>";
					}

				}

			}
		} catch (final Exception e) {
			/*LogTracer.writeTracerLog(className, methodName, e);
			LogTracer.writeExceptionLog(className, methodName, e);*/
		}

		return strHtml;
	}

	
	public static String getHtmlBlockListBoxId(final ArrayList alResults,
			final String selectName, final String idName, final String strJSFnName,
			final String size,final String multiple) {
		String strHtml = "";
		final String methodName = METHODHTMLBLOCK;
		//LogTracer.writeDebugLog(className, methodName, AppConstants.METHOD_START);

		try {
			if ((alResults != null) && (!alResults.isEmpty())) {
				//String[] strIdValue = {};
			/*	strHtml += (SELECT + selectName + "\" " +IDVAL
						+ strJSFnName + "\" " + SIZETAG + size + "\" " + multiple + " >");
				strHtml += OPTIONS;	*/			
				
				
				strHtml += (SELECT + selectName + "\" " +IDVAL
						+ idName+ONCLICK
						+ strJSFnName + "\" "+STYLE+ "\" "+ SIZETAG + size + "\" " + multiple + " >");
				//strHtml += OPTIONS;
				
				for (int i = 0; i < alResults.size(); i++) {
					String[] strIdValue = (String[]) alResults.get(i);
					if ((strIdValue[0] != null)
							&& !strIdValue[0].equals("null")) {
						strIdValue[0] = strIdValue[0].trim();
					}

					if ((strIdValue[1] != null)
							&& !strIdValue[1].equals("null")) {
						strIdValue[1] = strIdValue[1].trim();
					}

					strHtml = strHtml + OPTIONTAG + strIdValue[0]
							+ "\">" + strIdValue[1] + ENDOPTIONTAG;
				}

				strHtml += ENDSELECT;
			}
		} catch (final Exception ex) {
			//LogTracer.writeExceptionLog(className, methodName, ex);
		}

		//LogTracer.writeDebugLog(className, methodName, AppConstants.METHOD_END);

		return strHtml;
	}	
	

	
	/* added by suneel */
	public static String getCheckBoxHtmlBlock(final ArrayList alResults,
			final String strChkBoxName, final String strJSFnName)
			throws Exception {
		final String methodName = "getCheckBoxHtmlBlock";

		String strHtml = "";
		int j = 0;
		int w = 0;
		String[] strCheckBoxValues = {};
		String[] strCheckBoxNames = {};
		//LogTracer.writeDebugLog(className, methodName, "Start");
		try {
			if ((alResults != null) && (alResults.size() > 0)) {
				strCheckBoxValues = new String[alResults.size()];
				strCheckBoxNames = new String[alResults.size()];
				for (int i = 0; i < alResults.size(); i++) {
					final String[] tempValues = (String[]) alResults.get(i);
					strCheckBoxValues[w] = tempValues[0];
					strCheckBoxNames[w] = tempValues[1];
					if (w < strCheckBoxValues.length) {
						w++;
					}
				}
				for (int i = 0; i < strCheckBoxValues.length; i++) {
					if ((i % 2) == 0) {
						if (i < (strCheckBoxValues.length - 1)) {
							strHtml = strHtml
									+ "<tr>"
									+ "<td height='24'><input type='checkbox' name='checkBox' value='"
									+ strCheckBoxValues[j]
									+ "' "
									+ strJSFnName
									+ "/>"
									+ "<strong> "
									+ strCheckBoxNames[j]
									+ "</strong></td>"
									+ "<td><input type='checkbox' name='checkBox' value='"
									+ strCheckBoxValues[j + 1] + "' "
									+ strJSFnName + "/>" + "<strong>"
									+ strCheckBoxNames[j + 1]
									+ "</strong></td>" + "</tr>";
							j = j + 2;
							strHtml = strHtml + "\n";
							i = i + 1;
						}

					}
					if ((i == (strCheckBoxValues.length - 1))
							&& ((strCheckBoxValues.length % 2) != 0)) {
						strHtml = strHtml
								+ "\n<tr>"
								+ "<td height='24'><input type='checkbox' name='checkBox' value='"
								+ strCheckBoxValues[i] + "' " + strJSFnName
								+ "/>" + "<strong>" + strCheckBoxNames[i]
								+ "</strong></td>" + "</tr>";
					}
				}

			}
		} catch (final Exception e) {
			/*LogTracer.writeTracerLog(className, methodName, e);
			LogTracer.writeExceptionLog(className, methodName, e);*/
		}

		return strHtml;
	}

	/* end by suneel */

	public static String getCheckBoxHtmlBlockPreCheck(
			final ArrayList alResults, final String strChkBoxName,
			final String strJSFnName, final String strSelected, final String[] mappedLdapRoles)
			throws Exception {
		final String methodName = "getCheckBoxHtmlBlockPreCheck";
		//LogTracer.writeDebugLog(className, methodName, "Start");
		String strHtml = "";
		int j = 0;
		int w = 0;
		String[] strCheckBoxValues = {};
		String[] strCheckBoxNames = {};

		try {
			if ((alResults != null) && (alResults.size() > 0)) {
				strCheckBoxValues = new String[alResults.size()];
				strCheckBoxNames = new String[alResults.size()];
				for (int i = 0; i < alResults.size(); i++) {
					final String[] tempValues = (String[]) alResults.get(i);
					strCheckBoxValues[w] = tempValues[0];
					strCheckBoxNames[w] = tempValues[1];
					if (w < strCheckBoxValues.length) {
						w++;
					}
				}
				for (int i = 0; i < strCheckBoxValues.length; i++) {

					if ((i % 2) == 0) {
						if (i < (strCheckBoxValues.length - 1)) {
							strHtml = strHtml
									+ "<tr>"
									+ "<td height='24'><input type='checkbox' name='"
									+ strChkBoxName
									+ "' value='"
									+ strCheckBoxValues[j]
									+ "' "
									+ strJSFnName
									+ "  "
									+ isChecked(strSelected,
											strCheckBoxValues[j],mappedLdapRoles)
									+ "/>"
									+ "<strong> "
									+ strCheckBoxNames[j]
									+ "</strong></td>"
									+ "<td><input type='checkbox' name='"
									+ strChkBoxName
									+ "' value='"
									+ strCheckBoxValues[j + 1]
									+ "' "
									+ strJSFnName
									+ "  "
									+ isChecked(strSelected,
											strCheckBoxValues[j + 1],mappedLdapRoles) + "/>"
									+ "<strong>" + strCheckBoxNames[j + 1]
									+ "</strong></td>" + "</tr>";
							j = j + 2;
							strHtml = strHtml + "\n";
							i = i + 1;
						}
					}
					if ((i == (strCheckBoxValues.length - 1))
							&& ((strCheckBoxValues.length % 2) != 0)) {
						strHtml = strHtml
								+ "\n<tr>"
								+ "<td height='24'><input type='checkbox' name='"
								+ strChkBoxName + "' value='"
								+ strCheckBoxValues[i] + "' " + strJSFnName
								+ "  "
								+ isChecked(strSelected, strCheckBoxValues[i],mappedLdapRoles)
								+ "/>" + "<strong>" + strCheckBoxNames[i]
								+ "</strong></td>" + "</tr>";
					}
				}
			}
		} catch (final Exception e) {
			/*LogTracer.writeExceptionLog(className, methodName, e);*/
		}
		/*LogTracer.writeDebugLog(className, methodName, "End");*/
		return strHtml;
	}

	/**
	 * Gets the displayValue attribute of the HtmlUtil class
	 * 
	 * @param arrList
	 *            ArrayList
	 * @param strValue
	 *            String
	 * @return The displayValue value String
	 */
	public static String getDisplayValue(final ArrayList arrList,
			final String strValue) {
		final String methodName = "getDisplayValue";
		/*LogTracer.writeDebugLog(className, methodName, "Start");
		LogTracer.writeDebugLog(className, methodName, "End");*/

		return getDisplayValue(arrList, strValue, 1);
	}

	public static String getDisplayValue(final ArrayList arrList,
			final String strValue, final int ii) {
		String strDisValue = "";
		final String methodName = "getDisplayValue";
		/*LogTracer.writeDebugLog(className, methodName, "Start");*/

		if ((arrList != null) && (arrList.size() != 0)) {
			for (int i = 0; i < arrList.size(); i++) {
				final String[] strList = (String[]) arrList.get(i);

				if (strList[0].equals(strValue)) {
					strDisValue = strList[ii];

					break;
				}
			}
		}

		//LogTracer.writeDebugLog(className, methodName, "End");

		return strDisValue;
	}

	public static String getHtmlBlock(final ArrayList alResults,
			final String selectName) {
		final String methodName = "getHtmlBlock";
		String strHtml = "";
		//LogTracer.writeDebugLog(className, methodName, "Start");

		try {
			if ((alResults != null) && (alResults.size() >= 0)) {
				String[] strIdValue = {};
				strHtml += ("<select name=\"" + selectName + "\" " + "size=\"9\"  MULTIPLE>");
				for (int i = 0; i < alResults.size(); i++) {
					strIdValue = (String[]) alResults.get(i);
					strHtml = strHtml + "<option value=\""
							+ strIdValue[1].trim() + "\">" + strIdValue[0]
							+ "</option>";
				}

				strHtml += "</select>";
			}
		} catch (final Exception ex) {
			//LogTracer.writeTracerLog(className, methodName, ex);
		}

		//LogTracer.writeDebugLog(className, methodName, "End");

		return strHtml;
	}

	/**
	 * Gets the htmlBlock attribute of the HtmlUtil class
	 * 
	 * @param alResults
	 *            ArrayList
	 * @param selectName
	 *            String
	 * @param strJSFnName
	 *            String
	 * @return The htmlBlock value
	 */
	public static String getHtmlBlock(final ArrayList alResults,
			final String selectName, final String strJSFnName) {
		final String methodName = "getHtmlBlock";
		String strHtml = "";
		//LogTracer.writeDebugLog(className, methodName, "Start");

		try {
			if ((alResults != null) && (alResults.size() >= 0)) {
				String[] strIdValue = {};
				strHtml += ("<select name=\"" + selectName + "\" "
						+ strJSFnName + ">");
				strHtml += "<option value=\"\"></option>";

				for (int i = 0; i < alResults.size(); i++) {
					strIdValue = (String[]) alResults.get(i);

					if ((strIdValue[0] != null)
							&& !strIdValue[0].equals("null")) {
						strIdValue[0] = strIdValue[0].trim();
					}

					if ((strIdValue[1] != null)
							&& !strIdValue[1].equals("null")) {
						strIdValue[1] = strIdValue[1].trim();
					}
					strHtml = strHtml + "<option value=\"" + strIdValue[0]
							+ "\">" + strIdValue[1] + "</option>";
				}

				strHtml += "</select>";
			}
		} catch (final Exception ex) {
			//LogTracer.writeExceptionLog(className, methodName, ex.getMessage());
		}

		//LogTracer.writeDebugLog(className, methodName, "End");

		return strHtml;
	}
	public static String getHtmlBlockWithStateAll(final ArrayList alResults,
			final String selectName, final String strJSFnName) {
		final String methodName = "getHtmlBlock";
		String strHtml = "";
		String stateAll = "ALL";
		//LogTracer.writeDebugLog(className, methodName, "Start");

		try {
			if ((alResults != null) && (alResults.size() >= 0)) {
				String[] strIdValue = {};
				strHtml += ("<select name=\"" + selectName + "\" "
						+ strJSFnName + ">");
				strHtml += "<option value=\"\"></option>";
				strHtml = strHtml + "<option value=\"" + stateAll
						+ "\">" + stateAll + "</option>";

				for (int i = 0; i < alResults.size(); i++) {
					strIdValue = (String[]) alResults.get(i);

					if ((strIdValue[0] != null)
							&& !strIdValue[0].equals("null")) {
						strIdValue[0] = strIdValue[0].trim();
					}

					if ((strIdValue[1] != null)
							&& !strIdValue[1].equals("null")) {
						strIdValue[1] = strIdValue[1].trim();
					}
					strHtml = strHtml + "<option value=\"" + strIdValue[0]
							+ "\">" + strIdValue[1] + "</option>";
				}

				strHtml += "</select>";
			}
		} catch (final Exception ex) {
			//LogTracer.writeExceptionLog(className, methodName, ex.getMessage());
		}

		//LogTracer.writeDebugLog(className, methodName, "End");

		return strHtml;
	}

	/**/
	public static String getHtmlBlock(final ArrayList alResults,
			final String selectName, final String strJSFnName,
			final int maxLength) {
		final String methodName = "getHtmlBlock";
		//LogTracer.writeDebugLog(className, methodName, "Start");

		String strHtml = "";

		try {
			if ((alResults != null) && (alResults.size() >= 0)) {
				String[] strIdValue = {};
				strHtml += ("<select name=\"" + selectName + "\" "
						+ strJSFnName + ">");
				strHtml += ("<option value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>");

				for (int i = 0; i < alResults.size(); i++) {
					strIdValue = (String[]) alResults.get(i);

					if ((strIdValue[0] != null)
							&& !strIdValue[0].equals("null")) {
						strIdValue[0] = strIdValue[0].trim();
					}

					if ((strIdValue[1] != null)
							&& !strIdValue[1].equals("null")) {
						strIdValue[1] = strIdValue[1].trim();
					}

					strHtml = strHtml + "<option value=\"" + strIdValue[0]
							+ "\">" + strIdValue[1] + "</option>";
				}

				strHtml += "</select>";
			}
		} catch (final Exception ex) {
			//LogTracer.writeExceptionLog(className, methodName, ex.getMessage());
		}

		//LogTracer.writeDebugLog(className, methodName, "End");

		return strHtml;
	}

	/**
	 * Gets the htmlBlock attribute of the HtmlUtil class
	 * 
	 * @param alResults
	 *            ArrayList
	 * @param selectName
	 *            String
	 * @param strJSFnName
	 *            String
	 * @param strSelectValue
	 *            String
	 * @return The htmlBlock value String
	 */
	public static String getHtmlBlock(final ArrayList alResults,
			final String selectName, final String strJSFnName,
			final String strSelectValue) {
		if ((strSelectValue == null) || strSelectValue.equals("")) {
			return getHtmlBlock(alResults, selectName, strJSFnName);
		}

		String strHtml = "";
		String strSelected = "";
		final String methodName = "getHtmlBlock";
		//LogTracer.writeDebugLog(className, methodName, "Start");

		try {
			if ((alResults != null) && (alResults.size() > 0)) {
				String[] strIdValue = {};

				strHtml += ("<select name=\"" + selectName + "\" "
						+ strJSFnName + ">");
				strHtml += "<option value=\"\"></option>";

				for (int i = 0; i < alResults.size(); i++) {
					strSelected = "";
					strIdValue = (String[]) alResults.get(i);

					if ((strIdValue[0] != null)
							&& !strIdValue[0].equals("null")) {
						strIdValue[0] = strIdValue[0].trim();
					}

					if ((strIdValue[1] != null)
							&& !strIdValue[1].equals("null")) {
						strIdValue[1] = strIdValue[1].trim();
					}

					if (strSelectValue.trim().equals(strIdValue[0])) {
						strSelected = "selected";
					}

					strHtml = strHtml + "<option value=\"" + strIdValue[0]
							+ "\" " + strSelected + " >" + strIdValue[1]
							+ "</option>";
				}

				strHtml += "</select>";
			}
		} catch (final Exception ex) {
			//LogTracer.writeExceptionLog(className, methodName, ex.getMessage());
		}

		//LogTracer.writeDebugLog(className, methodName, "End");

		return strHtml;
	}

	/* For Location 30-10-03 */
	public static String getHtmlBlock(final ArrayList alResults,
			final String selectName, final String strJSFnName,
			final String strSelectValue, final int ii, final int jj) {
		// removed SOP
		if ((strSelectValue == null) || strSelectValue.equals("")) {
			return getHtmlBlockForLocation(alResults, selectName, strJSFnName);
		}

		String strHtml = "";
		String strSelected = "";
		final String methodName = "getHtmlBlock";
		//LogTracer.writeDebugLog(className, methodName, "Start");

		try {
			if ((alResults != null) && (alResults.size() > 0)) {
				String[] strIdValue = {};

				strHtml += ("<select name=\"" + selectName + "\" "
						+ strJSFnName + ">");
				strHtml += "<option value=\"\"></option>";

				for (int i = 0; i < alResults.size(); i++) {
					strSelected = "";
					strIdValue = (String[]) alResults.get(i);

					if ((strIdValue[0] != null)
							&& !strIdValue[0].equals("null")) {
						strIdValue[0] = strIdValue[0].trim();
					}

					if (strSelectValue.trim().equals(strIdValue[0])) {
						strSelected = "selected";
					}

					strHtml = strHtml + "<option value=\"" + strIdValue[0]
							+ "\" " + strSelected + " >" + strIdValue[0]
							+ "</option>";
				}

				strHtml += "</select>";
			}
		} catch (final Exception ex) {
			//LogTracer.writeExceptionLog(className, methodName, ex.getMessage());
		}

		//LogTracer.writeDebugLog(className, methodName, "End");

		return strHtml;
	}

	/**
	 * Gets the htmlBlock attribute of the HtmlUtil class
	 * 
	 * @param alResults
	 *            ArrayList
	 * @param selectName
	 *            String
	 * @param strJSFnName
	 *            String
	 * @param size
	 *            String
	 * @param multiple
	 *            String
	 * @return The htmlBlock value String
	 */
	public static String getHtmlBlock(final ArrayList alResults,
			final String selectName, final String strJSFnName,
			final String size, final String multiple) {
		String strHtml = "";
		final String methodName = "getHtmlBlock";
		//LogTracer.writeDebugLog(className, methodName, "Start");

		try {
			if ((alResults != null) && (alResults.size() > 0)) {
				String[] strIdValue = {};
				strHtml += ("<select name=\"" + selectName + "\" "
						+ strJSFnName + " size=\"" + size + "\" " + multiple + " >");
				strHtml += "<option value=\"\"></option>";

				for (int i = 0; i < alResults.size(); i++) {
					strIdValue = (String[]) alResults.get(i);

					if ((strIdValue[0] != null)
							&& !strIdValue[0].equals("null")) {
						strIdValue[0] = strIdValue[0].trim();
					}

					if ((strIdValue[1] != null)
							&& !strIdValue[1].equals("null")) {
						strIdValue[1] = strIdValue[1].trim();
					}

					strHtml = strHtml + "<option value=\"" + strIdValue[0]
							+ "\">" + strIdValue[1] + "</option>";
				}

				strHtml += "</select>";
			}
		} catch (final Exception ex) {
			//LogTracer.writeExceptionLog(className, methodName, ex.getMessage());
		}

		//LogTracer.writeDebugLog(className, methodName, "End");

		return strHtml;
	}

	/**
	 * Gets the htmlBlock attribute of the HtmlUtil class
	 * 
	 * @param alResults
	 *            ArrayList
	 * @param selectName
	 *            String
	 * @param strJSFnName
	 *            String
	 * @param size
	 *            String
	 * @param multiple
	 *            String
	 * @param selValues
	 *            String
	 * @return The htmlBlock value String
	 */
	public static String getHtmlBlock(final ArrayList alResults,
			final String selectName, final String strJSFnName,
			final String size, final String multiple, final String selValues) {
		String strHtml = "";
		final String methodName = "getHtmlBlock";
		//LogTracer.writeDebugLog(className, methodName, "Start");

		try {
			final StringTokenizer token = new StringTokenizer(selValues.trim(),
					",");
			final HashMap map = new HashMap();

			while (token.hasMoreTokens()) {
				final String nextToken = token.nextToken().trim();
				map.put(nextToken, nextToken);
			}

			if ((alResults != null) && (alResults.size() > 0)) {
				String[] strIdValue = {};
				strHtml += ("<select name=\"" + selectName + "\" "
						+ strJSFnName + " size=\"" + size + "\" " + multiple + " >");
				strHtml += "<option value=\"\"></option>";

				for (int i = 0; i < alResults.size(); i++) {
					strIdValue = (String[]) alResults.get(i);

					if ((strIdValue[0] != null)
							&& !strIdValue[0].equals("null")) {
						strIdValue[0] = strIdValue[0].trim();
					}

					if ((strIdValue[1] != null)
							&& !strIdValue[1].equals("null")) {
						strIdValue[1] = strIdValue[1].trim();
					}

					if (map.containsKey(strIdValue[0])) {
						strHtml = strHtml + "<option value=\"" + strIdValue[0]
								+ "\" selected>" + strIdValue[1] + "</option>";
					} else {
						strHtml = strHtml + "<option value=\"" + strIdValue[0]
								+ "\">" + strIdValue[1] + "</option>";
					}
				}

				strHtml += "</select>";
			}
		} catch (final Exception ex) {
			//LogTracer.writeExceptionLog(className, methodName, ex.getMessage());
		}

		//LogTracer.writeDebugLog(className, methodName, "End");

		return strHtml;
	}

	public static String getHtmlBlockAppStatus(final ArrayList alResults,
			final String selectName, final String strJSFnName) {
		final String methodName = "getHtmlBlock";
		String strHtml = "";
		//LogTracer.writeDebugLog(className, methodName, "Start");

		try {
			if ((alResults != null) && (alResults.size() >= 0)) {
				String[] strIdValue = {};
				strHtml += ("<select name=\"" + selectName
						+ "\" onchange='checkStatus(this);' " + strJSFnName + ">");
				strHtml += "<option value=\"\"></option>";

				for (int i = 0; i < alResults.size(); i++) {
					strIdValue = (String[]) alResults.get(i);
					strHtml = strHtml + "<option value=\""
							+ strIdValue[0].trim() + "\">"
							+ strIdValue[1].trim() + "</option>";
				}

				strHtml += "</select>";
			}
		} catch (final Exception ex) {
			//LogTracer.writeTracerLog(className, methodName, ex);
		}

		//LogTracer.writeDebugLog(className, methodName, "End");

		return strHtml;
	}

	public static String getHtmlBlockAssignTo(final ArrayList alResults,
			final String selectName, final String strJSFnName) {
		final String methodName = "getHtmlBlock";
		String strHtml = "";
		//LogTracer.writeDebugLog(className, methodName, "Start");

		try {
			if ((alResults != null) && (alResults.size() >= 0)) {
				String[] strIdValue = {};
				strHtml += ("<select name=\"" + selectName + "\" "
						+ strJSFnName + ">");
				strHtml += "<option value=\"\"></option>";
				strHtml += "<option value=\"29\">Not Assigned</option>";			

				for (int i = 0; i < alResults.size(); i++) {
					strIdValue = (String[]) alResults.get(i);
					strHtml = strHtml + "<option value=\""
							+ strIdValue[0].trim() + "\">"
							+ strIdValue[1].trim() + "</option>";
				}

				strHtml += "</select>";
			}
		} catch (final Exception ex) {
			//LogTracer.writeTracerLog(className, methodName, ex);
		}

		//LogTracer.writeDebugLog(className, methodName, "End");

		return strHtml;
	}

	public static String getHtmlBlockCC(final ArrayList alResults,
			final String selectName, final String strJSFnName,
			final String strSelectValue) {
		if ((strSelectValue == null) || strSelectValue.equals("")) {
			return getHtmlBlock(alResults, selectName, strJSFnName);
		}

		String strHtml = "";
		String strSelected = "";
		final String methodName = "getHtmlBlockCC";
		//LogTracer.writeDebugLog(className, methodName, "Start");

		try {
			if (alResults.size() > 0) {
				String[] strIdValue = {};

				strHtml += ("<select name=\"" + selectName + "\" "
						+ strJSFnName + ">");
				// strHtml += "<option value=\"\"></option>";

				for (int i = 0; i < alResults.size(); i++) {
					strSelected = "";
					strIdValue = (String[]) alResults.get(i);

					if (strSelectValue.trim().equals(strIdValue[0].trim())) {
						strSelected = "selected";
					}

					strHtml = strHtml + "<option value=\""
							+ strIdValue[0].trim() + "\" " + strSelected + " >"
							+ strIdValue[1].trim() + "</option>";
				}

				strHtml += "</select>";
			}
		} catch (final Exception ex) {
			//LogTracer.writeTracerLog(className, methodName, ex);
		}

		//LogTracer.writeDebugLog(className, methodName, "End");

		return strHtml;
	}

	public static String getHtmlBlockCheckCashing(final ArrayList alResults,
			final String selectName, final String strJSFnName) {
		final String methodName = "getHtmlBlockCheckCashing";
		String strHtml = "";
		//LogTracer.writeDebugLog(className, methodName, "Start");

		try {
			if ((alResults != null) && (alResults.size() >= 0)) {
				String[] strIdValue = {};
				strHtml += ("<select name=\"" + selectName + "\" "
						+ strJSFnName + ">");
				strHtml += "<option value=\"\"></option>";

				for (int i = 0; i < alResults.size(); i++) {
					strIdValue = (String[]) alResults.get(i);

					if ((strIdValue[0] != null)
							&& !strIdValue[0].equals("null")) {
						strIdValue[0] = strIdValue[0].trim();
					}

					if ((strIdValue[1] != null)
							&& !strIdValue[1].equals("null")) {
						strIdValue[1] = strIdValue[1].trim();
					}

					if ((strIdValue[2] != null)
							&& !strIdValue[2].equals("null")) {
						strIdValue[2] = strIdValue[2].trim();
					}

					if ((strIdValue[3] != null)
							&& !strIdValue[3].equals("null")) {
						strIdValue[3] = strIdValue[3].trim();
					}

					final String strValue = strIdValue[0] + "~" + strIdValue[1]
							+ "~" + strIdValue[2];
					strHtml = strHtml + "<option value=\"" + strValue + "\">"
							+ strIdValue[3] + "</option>";
				}

				strHtml += "</select>";
			}
		} catch (final Exception ex) {
			//LogTracer.writeExceptionLog(className, methodName, ex.getMessage());
		}

		//LogTracer.writeDebugLog(className, methodName, "End");

		return strHtml;
	}

	/*
	 * Author : JSR This method is used to get checkcashingType details . return
	 * : FEEPCT,FEECHG,CHKCASHTYPE,DESCRIPTION
	 */
	public static String getHtmlBlockCheckCashing(final ArrayList alResults,
			final String selectName, final String strJSFnName,
			final String strSelectValue) {
		if ((strSelectValue == null) || strSelectValue.equals("")) {
			return getHtmlBlockCheckCashing(alResults, selectName, strJSFnName);
		}

		String strHtml = "";
		String strSelected = "";
		final String methodName = "getHtmlBlockCheckCashing";
		//LogTracer.writeDebugLog(className, methodName, "Start");

		try {
			if ((alResults != null) && (alResults.size() > 0)) {
				String[] strIdValue = {};

				strHtml += ("<select name=\"" + selectName + "\" "
						+ strJSFnName + ">");
				strHtml += "<option value=\"\"></option>";

				for (int i = 0; i < alResults.size(); i++) {
					strSelected = "";
					strIdValue = (String[]) alResults.get(i);

					if ((strIdValue[0] != null)
							&& !strIdValue[0].equals("null")) {
						strIdValue[0] = strIdValue[0].trim();
					}

					if ((strIdValue[1] != null)
							&& !strIdValue[1].equals("null")) {
						strIdValue[1] = strIdValue[1].trim();
					}

					if ((strIdValue[2] != null)
							&& !strIdValue[2].equals("null")) {
						strIdValue[2] = strIdValue[2].trim();
					}

					if ((strIdValue[3] != null)
							&& !strIdValue[3].equals("null")) {
						strIdValue[3] = strIdValue[3].trim();
					}

					final String strValue = strIdValue[0] + "~" + strIdValue[1]
							+ "~" + strIdValue[2];

					if (strSelectValue.trim().equals(strValue)) {
						strSelected = "selected";
					}

					strHtml = strHtml + "<option value=\"" + strValue.trim()
							+ "\" " + strSelected + " >" + strIdValue[3]
							+ "</option>";
				}

				strHtml += "</select>";
			}
		} catch (final Exception ex) {
			//LogTracer.writeExceptionLog(className, methodName, ex.getMessage());
		}

		//LogTracer.writeDebugLog(className, methodName, "End");

		return strHtml;
	}

	public static String getHtmlBlockCollectionTo(final ArrayList alResults,
			final String selectName, final String strJSFnName) {
		final String methodName = "getHtmlBlockCollectionTo";
		String strHtml = "";
		//LogTracer.writeDebugLog(className, methodName, "Start");

		try {
			if ((alResults != null) && (alResults.size() >= 0)) {
				String[] strIdValue = {};
				strHtml += ("<select name=\"" + selectName + "\" "
						+ strJSFnName + ">");
				strHtml += "<option value=\"\"></option>";
				strHtml += "<option value=\"29\">Not Assigned</option>";

				for (int i = 0; i < alResults.size(); i++) {
					strIdValue = (String[]) alResults.get(i);
					strHtml = strHtml + "<option value=\""
							+ strIdValue[0].trim() + "\">"
							+ strIdValue[1].trim() + "</option>";
				}

				strHtml += "</select>";
			}
		} catch (final Exception ex) {
			//LogTracer.writeTracerLog(className, methodName, ex);
		}

		//LogTracer.writeDebugLog(className, methodName, "End");

		return strHtml;
	}

	public static String getHtmlBlockDefault(final ArrayList alResults,
			final String selectName, final String strJSFnName) {
		final String methodName = "getHtmlBlockDefault";
		String strHtml = "";
		// LogTracer.writeDebugLog(className, methodName, "Start");

		try {
			if ((alResults != null) && (alResults.size() >= 0)) {
				String[] strIdValue = {};
				strHtml += ("<select name=\"" + selectName + "\" "
						+ strJSFnName + ">");
				for (int i = 0; i < alResults.size(); i++) {
					strIdValue = (String[]) alResults.get(i);
					strHtml = strHtml + "<option value=\""
							+ strIdValue[0].trim() + "\">"
							+ strIdValue[1].trim() + "</option>";
				}

				strHtml += "</select>";
			}
		} catch (final Exception ex) {
			//LogTracer.writeTracerLog(className, methodName, ex);
		}

		// LogTracer.writeDebugLog(className, methodName, "End");

		return strHtml;
	}

	public static String getHtmlBlockDefault(final ArrayList alResults,
			final String selectName, final String strJSFnName,
			final String strSelectValue) {
		if ((strSelectValue == null) || strSelectValue.equals("")) {
			return getHtmlBlockDefault(alResults, selectName, strJSFnName);
		}

		String strHtml = "";
		String strSelected = "";
		final String methodName = "getHtmlBlockDefault";
		// LogTracer.writeDebugLog(className, methodName, "Start");

		try {
			if (alResults.size() > 0) {
				String[] strIdValue = {};

				strHtml += ("<select name=\"" + selectName + "\" "
						+ strJSFnName + ">");

				for (int i = 0; i < alResults.size(); i++) {
					strSelected = "";
					strIdValue = (String[]) alResults.get(i);

					if (strSelectValue.trim().equals(strIdValue[0].trim())) {
						strSelected = "selected";
					}

					strHtml = strHtml + "<option value=\""
							+ strIdValue[0].trim() + "\" " + strSelected + " >"
							+ strIdValue[1].trim() + "</option>";
				}

				strHtml += "</select>";
			}
		} catch (final Exception ex) {
			//LogTracer.writeTracerLog(className, methodName, ex);
		}

		return strHtml;
	}

	/*
	 * public static String getHtmlBlockForAdvance(ArrayList alResults, String
	 * selectName, String strJSFnName )
	 */
	public static String getHtmlBlockForAdvance(final ArrayList alResults,
			final String selectName, final String strJSFnName,
			final String strSelectValue) {
		final String methodName = "getHtmlBlockForAdvance";
		//LogTracer.writeDebugLog(className, methodName, "Start");

		String strHtml = "";

		try {
			if ((alResults != null) && (alResults.size() >= 0)) {
				String[] strIdValue = {};
				strHtml += ("<select name=\"" + selectName + "\" "
						+ strJSFnName + ">");
				strHtml += ("<option value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ "&nbsp;&nbsp;</option>");

				for (int i = 0; i < alResults.size(); i++) {
					strIdValue = (String[]) alResults.get(i);

					if ((strIdValue[0] != null)
							&& !strIdValue[0].equals("null")) {
						strIdValue[0] = strIdValue[0].trim();
					}

					if ((strIdValue[1] != null)
							&& !strIdValue[1].equals("null")) {
						strIdValue[1] = strIdValue[1].trim();
					}

					strHtml = strHtml + "<option value=\"" + strIdValue[0]
							+ "\">" + strIdValue[1] + "</option>";
				}

				strHtml += "</select>";
			}
		} catch (final Exception ex) {
			//LogTracer.writeExceptionLog(className, methodName, ex.getMessage());
		}

		//LogTracer.writeDebugLog(className, methodName, "End");

		return strHtml;
	}

	public static String getHtmlBlockForAmounts(final ArrayList alResults,
			final String selectName, final String strJSFnName,
			final String strSelectValue) {
		if ((strSelectValue == null) || strSelectValue.equals("")) {
			return getHtmlBlock(alResults, selectName, strJSFnName);
		}

		String strHtml = "";
		String strSelected = "";
		final String methodName = "getHtmlBlockForAmounts";
		//LogTracer.writeDebugLog(className, methodName, "Start");

		try {
			if (alResults.size() > 0) {
				String[] strIdValue = {};

				strHtml += ("<select name=\"" + selectName + "\" "
						+ strJSFnName + ">");
				strHtml += "<option value=\"\"></option>";

				for (int i = 0; i < alResults.size(); i++) {
					strSelected = "";
					strIdValue = (String[]) alResults.get(i);
					/*com.vcl.util.LogTracer
							.writeSOP("---------------1111------------------------>"
									+ strSelectValue.trim());
					com.vcl.util.LogTracer
							.writeSOP("----------------2222----------------------->"
									+ strIdValue[0].trim());*/

					if (Double.parseDouble(strSelectValue.trim()) == Double
							.parseDouble(strIdValue[0].trim())) {
						/*com.vcl.util.LogTracer
								.writeSOP("------------------Selected--------------------->");*/
						strSelected = "selected";
					}

					strHtml = strHtml + "<option value=\""
							+ strIdValue[0].trim() + "\" " + strSelected + " >"
							+ strIdValue[1].trim() + "</option>";
				}

				strHtml += "</select>";
			}
		} catch (final Exception ex) {
			//LogTracer.writeTracerLog(className, methodName, ex);
		}

		//LogTracer.writeDebugLog(className, methodName, "End");

		return strHtml;
	}

	/*
	 * Author : JSR This method is used to get checkcashingType details . return
	 * : FEEPCT,FEECHG,CHKCASHTYPE,DESCRIPTION
	 */

	public static String getHtmlBlockForCallStatus(final ArrayList alResults,
			final String selectName, final String strJSFnName,
			final String strSelectValue) {
		if ((strSelectValue == null) || strSelectValue.equals("")) {
			return getHtmlBlock(alResults, selectName, strJSFnName);
		}

		String strHtml = "";
		String strSelected = "";
		final String methodName = "getHtmlBlock";
		//LogTracer.writeDebugLog(className, methodName, "Start");

		try {
			if (alResults.size() > 0) {
				String[] strIdValue = {};

				strHtml += ("<select name=\"" + selectName + "\" "
						+ strJSFnName + ">");
				strHtml += "<option value=\"0\"></option>";

				for (int i = 0; i < alResults.size(); i++) {
					strSelected = "";
					strIdValue = (String[]) alResults.get(i);

					if (strSelectValue.trim().equals(strIdValue[0].trim())) {
						strSelected = "selected";
					}

					strHtml = strHtml + "<option value=\""
							+ strIdValue[0].trim() + "\" " + strSelected + " >"
							+ strIdValue[1].trim() + "</option>";
				}

				strHtml += "</select>";
			}
		} catch (final Exception ex) {
			//LogTracer.writeTracerLog(className, methodName, ex);
		}

		//LogTracer.writeDebugLog(className, methodName, "End");

		return strHtml;
	}

	public static String getHtmlBlockForLoan(final ArrayList alResults,
			final String selectName, final String strJSFnName,
			final String strSelectValue) {
		if ((strSelectValue == null) || strSelectValue.equals("")) {
			return getHtmlBlock(alResults, selectName, strJSFnName);
		}

		String strHtml = "";
		String strSelected = "";
		final String methodName = "getHtmlBlock";
		//LogTracer.writeDebugLog(className, methodName, "Start");

		try {
			if (alResults.size() > 0) {
				String[] strIdValue = {};

				strHtml += ("<select name=\"" + selectName + "\" "
						+ strJSFnName + ">");
				// strHtml += "<option value=\"\"></option>";

				for (int i = 0; i < alResults.size(); i++) {
					strSelected = "";
					strIdValue = (String[]) alResults.get(i);

					if (strSelectValue.trim().equals(strIdValue[0].trim())) {
						strSelected = "selected";
					}

					strHtml = strHtml + "<option value=\""
							+ strIdValue[0].trim() + "\" " + strSelected + " >"
							+ strIdValue[1].trim() + "</option>";
				}

				strHtml += "</select>";
			}
		} catch (final Exception ex) {
			//LogTracer.writeTracerLog(className, methodName, ex);
		}

		//LogTracer.writeDebugLog(className, methodName, "End");

		return strHtml;
	}

	public static String getHtmlBlockForLocation(final ArrayList alResults,
			final String selectName, final String strJSFnName) {
		// removed SOP
		final String methodName = "getHtmlBlockForLocation";

		//LogTracer.writeDebugLog(className, methodName, "Start");

		String strHtml = "";

		try {
			if ((alResults != null) && (alResults.size() >= 0)) {
				String[] strIdValue = {};
				strHtml += ("<select class='dropDownAuto' name=\"" + selectName + "\" "
						+ strJSFnName + ">");
				strHtml += "<option value=\"\"></option>";

				for (int i = 0; i < alResults.size(); i++) {
					strIdValue = (String[]) alResults.get(i);

					if ((strIdValue[0] != null)
							&& !strIdValue[0].equals("null")) {
						strIdValue[0] = strIdValue[0].trim();
					}

					strHtml = strHtml + "<option value=\"" + strIdValue[0]
							+ "\">" + strIdValue[0] + "</option>";
				}

				strHtml += "</select>";
			}
		} catch (final Exception ex) {
			//LogTracer.writeExceptionLog(className, methodName, ex.getMessage());
		}

		//LogTracer.writeDebugLog(className, methodName, "End");

		return strHtml;
	}

	public static String getHtmlBlockForRules(final ArrayList alResults,
			final String selectName, final String strJSFnName,
			final String size, final String multiple, final String selValues,
			final int id) {
		String strHtml = "";
		final String methodName = "getHtmlBlockForRules";
		//LogTracer.writeDebugLog(className, methodName, "Start");

		try {
			final StringTokenizer token = new StringTokenizer(selValues.trim(),
					",");
			final HashMap map = new HashMap();

			while (token.hasMoreTokens()) {
				final String nextToken = token.nextToken().trim();
				map.put(nextToken, nextToken);
			}

			if ((alResults != null) && (alResults.size() > 0)) {
				String[] strIdValue = {};
				strHtml += ("<select name=\"" + selectName + "\" "
						+ strJSFnName + " size=\"" + size + "\" " + multiple + " >");
				strHtml += "<option id=\"defaultValue-" + id
						+ "\" value=\"\"></option>";

				for (int i = 0; i < alResults.size(); i++) {
					strIdValue = (String[]) alResults.get(i);

					if ((strIdValue[0] != null)
							&& !strIdValue[0].equals("null")) {
						strIdValue[0] = strIdValue[0].trim();
					}

					if ((strIdValue[1] != null)
							&& !strIdValue[1].equals("null")) {
						strIdValue[1] = strIdValue[1].trim();
					}

					if (map.containsKey(strIdValue[0])) {
						strHtml = strHtml + "<option id=\"defaultValue-" + id
								+ "\" value=\"" + strIdValue[0]
								+ "\" selected>" + strIdValue[1] + "</option>";
					} else {
						strHtml = strHtml + "<option id=\"defaultValue-" + id
								+ "\" value=\"" + strIdValue[0] + "\">"
								+ strIdValue[1] + "</option>";
					}
				}

				strHtml += "</select>";
			}
		} catch (final Exception ex) {
			//LogTracer.writeExceptionLog(className, methodName, ex.getMessage());
		}

		//LogTracer.writeDebugLog(className, methodName, "End");

		return strHtml;
	}

	public static String getHtmlBlockForRuleVals(final ArrayList alResults,
			final String selectName, final String strJSFnName, final int idNum) {
		// removed SOP
		final String methodName = "getHtmlBlockForRuleVals";

		//LogTracer.writeDebugLog(className, methodName, "Start");

		String strHtml = "";

		try {
			if ((alResults != null) && (alResults.size() >= 0)) {
				String[] strIdValue = {};
				strHtml += ("<select id=\"defaultValue-" + idNum + "\" name=\""
						+ selectName + "\" " + strJSFnName + ">");
				strHtml += "<option id=\"defaultValue-" + idNum
						+ "\" value=\"\"></option>";

				for (int i = 0; i < alResults.size(); i++) {
					strIdValue = (String[]) alResults.get(i);

					if ((strIdValue[0] != null)
							&& !strIdValue[0].equals("null")) {
						strIdValue[0] = strIdValue[0].trim();
					}

					strHtml = strHtml + "<option id=\"defaultValue-" + idNum
							+ "\" value=\"" + strIdValue[1] + "\">"
							+ strIdValue[0] + "</option>";
				}

				strHtml += "</select>";
			}
		} catch (final Exception ex) {
			//LogTracer.writeExceptionLog(className, methodName, ex.getMessage());
		}

		//LogTracer.writeDebugLog(className, methodName, "End");

		return strHtml;
	}

	public static String getHtmlBlockForRV(final ArrayList alResults,
			final String selectName, final String idName,
			final String strJSFnName, final String strSelectValue,
			final int idNum) {
		// removed SOP
		if ((strSelectValue == null) || strSelectValue.equals("")) {
			return getHtmlBlockForRuleVals(alResults, selectName, strJSFnName,
					idNum);
		}

		String strHtml = "";
		String strSelected = "";
		final String methodName = "getHtmlBlockForRV";
		//LogTracer.writeDebugLog(className, methodName, "Start");

		try {
			if ((alResults != null) && (alResults.size() > 0)) {
				String[] strIdValue = {};

				strHtml += ("<select id=\"defaultValue-" + idNum + "\" name=\""
						+ selectName + "\" " + strJSFnName + ">");
				strHtml += "<option id=\"defaultValue-" + idNum
						+ "\" value=\"\"></option>";

				for (int i = 0; i < alResults.size(); i++) {
					strSelected = "";
					strIdValue = (String[]) alResults.get(i);

					if ((strIdValue[0] != null)
							&& !strIdValue[0].equals("null")) {
						strIdValue[0] = strIdValue[0].trim();
					}

					if (strSelectValue.trim().equals(strIdValue[0])) {
						strSelected = "selected";
					}

					strHtml = strHtml + "<option id=\"defaultValue-" + idNum
							+ "\" value=\"" + strIdValue[0] + "\" "
							+ strSelected + " >" + strIdValue[1] + "</option>";
				}

				strHtml += "</select>";
			}
		} catch (final Exception ex) {
			//LogTracer.writeExceptionLog(className, methodName, ex.getMessage());
		}

		//LogTracer.writeDebugLog(className, methodName, "End");

		return strHtml;
	}

	public static String getHtmlBlockMulSel(final ArrayList alResults,
			final String selectName) {
		final String methodName = "getHtmlBlock";
		String strHtml = "";
		//LogTracer.writeDebugLog(className, methodName, "Start");

		try {
			if ((alResults != null) && (alResults.size() >= 0)) {
				String[] strIdValue = {};
				strHtml += ("<select name=\"" + selectName + "\" " + "size=\"4\"  MULTIPLE>");
				for (int i = 0; i < alResults.size(); i++) {
					strIdValue = (String[]) alResults.get(i);
					strHtml = strHtml + "<option value=\""
							+ strIdValue[1].trim() + "\">" + strIdValue[0]
							+ "</option>";
				}

				strHtml += "</select>";
			}
		} catch (final Exception ex) {
			//LogTracer.writeTracerLog(className, methodName, ex);
		}

		//LogTracer.writeDebugLog(className, methodName, "End");

		return strHtml;
	}

	public static String getHtmlBlockOptionGroupSel(final ArrayList alResults,
			final String selectName, final String strJSFnName,
			final String selctVal) {
		final String methodName = "getHtmlBlockOptionGroupSel";
		String strHtml = "";
		//LogTracer.writeDebugLog(className, methodName, "Start");

		try {
			if ((alResults != null) && (alResults.size() >= 0)) {
				String[] strIdValue = {};
				strHtml += ("<select name=\"" + selectName + "\" "
						+ strJSFnName + ">");
				strHtml += "<option value=\"\"></option>";

				for (int i = 0; i < alResults.size(); i++) {
					strIdValue = (String[]) alResults.get(i);
					if ((strIdValue.length > 2)
							&& "groupLabel".equals(strIdValue[2])) {
						strHtml = strHtml + "<optgroup label=\""
								+ strIdValue[1].trim() + "\">" + "</optgroup>";
					} else {
						String selected = "";
						if ((selctVal != null)
								&& (selctVal.trim()).equals(strIdValue[0]
										.trim())) {
							selected = "selected";
						}
						strHtml = strHtml + "<option " + selected + " value=\""
								+ strIdValue[0].trim() + "\">"
								+ strIdValue[1].trim() + "</option>";
					}

				}

				strHtml += "</select>";
			}
		} catch (final Exception ex) {
			//LogTracer.writeTracerLog(className, methodName, ex);
		}

		//LogTracer.writeDebugLog(className, methodName, "End");

		return strHtml;
	}

	public static String getHtmlBlockQueueList(final ArrayList alResults,
			final String selectName, final String strJSFnName) {
		final String methodName = "getHtmlBlockQueueList";
		String strHtml = "";
		//LogTracer.writeDebugLog(className, methodName, "Start");

		try {
			if ((alResults != null) && (alResults.size() >= 0)) {
				String[] strIdValue = {};
				strHtml += ("<select name=\"" + selectName + "\" "
						+ strJSFnName + ">");
				strHtml += "<option value=\"\"></option>";
				for (int i = 0; i < alResults.size(); i++) {
					strIdValue = (String[]) alResults.get(i);
					strHtml = strHtml + "<option value=\""
							+ strIdValue[0].trim() + "\">"
							+ strIdValue[1].trim() + "</option>";
				}

				strHtml += "</select>";
			}
		} catch (final Exception ex) {
			//LogTracer.writeTracerLog(className, methodName, ex);
		}

		//LogTracer.writeDebugLog(className, methodName, "End");

		return strHtml;
	}

	public static String getHtmlBlockThirdPartyAssignTo(
			final ArrayList alResults, final String selectName,
			final String strJSFnName) {
		final String methodName = "getHtmlBlockThirdPartyAssignTo";
		String strHtml = "";
		//LogTracer.writeDebugLog(className, methodName, "Start");

		try {
			if ((alResults != null) && (alResults.size() >= 0)) {
				String[] strIdValue = {};
				strHtml += ("<select name=\'" + selectName + "\' "
						+ strJSFnName + ">");
				strHtml += "<option value=\'\'></option>";
				strHtml += "<option value=\'29\'>Not Assigned</option>";
				strHtml += "<option value=\'30\'>Assigned</option>";
				strHtml += "<option value=\'99\'>SELF</option>";
				// strHtml += "<option value=\"30\">3rd Party</option>";
				for (int i = 0; i < alResults.size(); i++) {
					strIdValue = (String[]) alResults.get(i);					
					strHtml = strHtml + "<option value=\'"
							+ strIdValue[0].trim() + "\'>"
							+ strIdValue[1].trim()+ "</option>";
				}

				strHtml += "</select>";
			} else {
				strHtml += ("<select name=\'" + selectName + "\' "
						+ strJSFnName + ">");
				strHtml += "<option value=\'\'></option>";
				strHtml += "<option value=\'29\'>Not Assigned</option>";
				strHtml += "<option value=\'30\'>Assigned</option>";
				strHtml += "<option value=\'99\'>SELF</option>";
				// strHtml += "<option value=\"30\">3rd Party</option>";
				strHtml += "</select>";
			}
		} catch (final Exception ex) {
			//LogTracer.writeTracerLog(className, methodName, ex);
		}

		//LogTracer.writeDebugLog(className, methodName, "End");

		return strHtml;
	}

	public static String getHtmlBlockValues(final ArrayList alResults,
			final String selValues) {
		String returnValue = "";
		final String methodName = "getHtmlBlockValues";
		//LogTracer.writeDebugLog(className, methodName, "Start");

		try {
			final StringTokenizer token = new StringTokenizer(selValues.trim(),
					",");
			final HashMap map = new HashMap();

			while (token.hasMoreTokens()) {
				final String nextToken = token.nextToken().trim();

				map.put(nextToken, nextToken);
			}

			if ((alResults != null) && (alResults.size() > 0)) {
				String[] strIdValue = {};

				for (int i = 0; i < alResults.size(); i++) {
					strIdValue = (String[]) alResults.get(i);

					if ((strIdValue[0] != null)
							&& !strIdValue[0].equals("null")) {
						strIdValue[0] = strIdValue[0].trim();
					}

					if ((strIdValue[1] != null)
							&& !strIdValue[1].equals("null")) {
						strIdValue[1] = strIdValue[1].trim();
					}

					if (map.containsKey(strIdValue[0])) {
						returnValue += (strIdValue[1] + ",");
					}
				}
			}
		} catch (final Exception ex) {
			//LogTracer.writeExceptionLog(className, methodName, ex.getMessage());
		}

		if ((returnValue != null) && (returnValue.length() > 0)) {
			returnValue = returnValue
					.substring(0, returnValue.lastIndexOf(","));
		}

		//LogTracer.writeDebugLog(className, methodName, "End");

		return returnValue;
	}

	public static String getHtmlBNKBlock(final ArrayList alResults,
			final String selectName, final String strJSFnName,
			final String onChangeValue) {
		final String methodName = "getHtmlBNKBlock";
		String strHtml = "";
		//LogTracer.writeDebugLog(className, methodName, "Start");
		try {
			if ((alResults != null) && (alResults.size() >= 0)) {
				String[] strIdValue = {};
				strHtml += ("<select name=\"" + selectName + "\" onchange=\""
						+ onChangeValue + "\" " + strJSFnName + ">");
				strHtml += "<option value=\"\"></option>";
				for (int i = 0; i < alResults.size(); i++) {
					strIdValue = (String[]) alResults.get(i);
					if ((strIdValue[0] != null)
							&& !strIdValue[0].equals("null")) {
						strIdValue[0] = strIdValue[0].trim();
					}
					if ((strIdValue[1] != null)
							&& !strIdValue[1].equals("null")) {
						strIdValue[1] = strIdValue[1].trim();
					}
					strHtml = strHtml + "<option value=\"" + strIdValue[0]
							+ "\">" + strIdValue[1] + "</option>";
				}

				strHtml += "</select>";
			}
		} catch (final Exception ex) {
			//LogTracer.writeExceptionLog(className, methodName, ex);
		}
		return strHtml;
	}

	public static String getHtmlCheckedCheckBoxesBlock(
			final ArrayList alResults, final String strChkBoxName,
			final ArrayList alAssignedFlags) throws Exception {
		final String methodName = "getHtmlCheckedCheckBoxesBlock";
		String strHtml = "";
		String isMatched = "false";
		int j = 0;
		int w = 0;
		int m = 0;
		String[] strCheckBoxValues = {};
		String[] strCheckBoxNames = {};
		String[] strMatchedFlagsList = {};
		String[] strAssignedFlagsList = {};
		String selectedchkBoxesId = "";
		String prevSelChkBoxesId = "";
		//LogTracer.writeDebugLog(className, methodName, "Start");
		try {
			if ((alResults != null) && (alResults.size() > 0)) {
				strCheckBoxValues = new String[alResults.size()];
				strCheckBoxNames = new String[alResults.size()];
				strMatchedFlagsList = new String[alResults.size()];
				for (int i = 0; i < alResults.size(); i++) {
					final String[] tempValues = (String[]) alResults.get(i);
					strCheckBoxValues[w] = tempValues[0];
					strCheckBoxNames[w] = tempValues[1];
					strMatchedFlagsList[w] = "";
					if (w < strCheckBoxValues.length) {
						w++;
					}
				}
				if ((alAssignedFlags != null) && (alAssignedFlags.size() > 0)) {
					strAssignedFlagsList = new String[alAssignedFlags.size()];
					for (int i = 0; i < alAssignedFlags.size(); i++) {
						final String[] tempValues = (String[]) alAssignedFlags
								.get(i);

						strAssignedFlagsList[m] = tempValues[0];
						if (m < strAssignedFlagsList.length) {
							m++;
						}

					}
					for (int i = 0; i < strCheckBoxValues.length; i++) {
						for (int l = 0; l < strAssignedFlagsList.length; l++) {

							if (isMatched.equals("false")) {
								StringTokenizer st = new StringTokenizer(
										strCheckBoxValues[i], ",");
								while (st.hasMoreTokens()) {
									selectedchkBoxesId = st.nextToken();
									st.nextToken();
								}
								st = new StringTokenizer(
										strAssignedFlagsList[l], ",");
								while (st.hasMoreTokens()) {
									prevSelChkBoxesId = st.nextToken();
									st.nextToken();
								}
								if (prevSelChkBoxesId
										.equals(selectedchkBoxesId)) {
									isMatched = "true";
									// com.vcl.util.LogTracer.writeSOP("prevSelChkBoxesId "+prevSelChkBoxesId);
									if (prevSelChkBoxesId.equals("1")) {
										strMatchedFlagsList[i] = " CHECKED DISABLED ";
									} else {
										strMatchedFlagsList[i] = " CHECKED ";
									}
								}
							}
						}
						isMatched = "false";
					}
				}
				for (int i = 0; i < strCheckBoxValues.length; i++) {
					if ((i % 2) == 0) {
						if (i < (strCheckBoxValues.length - 1)) {
							if ("Deny New".equals(strCheckBoxNames[i])) {
								strHtml = strHtml
										+ "<tr>"
										+ "<td height='24'><input type='checkbox' name='checkBox' value='"
										+ strCheckBoxValues[j]
										+ "'"
										+ strMatchedFlagsList[j]
										+ " onClick='javascript:doProcess(this)'/>"
										+ "</td><td><strong> "
										+ strCheckBoxNames[j]
										+ "</strong></td>"
										+ "<td><input type='checkbox' name='checkBox' value='"
										+ strCheckBoxValues[j + 1] + "'"
										+ strMatchedFlagsList[j + 1] + " />"
										+ "</td><td><strong>"
										+ strCheckBoxNames[j + 1]
										+ "</strong></td>" + "</tr>";
							} else if ("SMS Opt In".equals(strCheckBoxNames[i])) {
								strHtml = strHtml
										+ "<tr>"
										+ "<td height='24'><input type='checkbox' name='checkBox' value='"
										+ strCheckBoxValues[j]
										+ "'"
										+ strMatchedFlagsList[j]
										+ " onClick='javascript:enableSMSDetails(this)'/>"
										+ "</td><td><strong> "
										+ strCheckBoxNames[j]
										+ "</strong></td>"
										+ "<td><input type='checkbox' name='checkBox' value='"
										+ strCheckBoxValues[j + 1] + "'"
										+ strMatchedFlagsList[j + 1] + " />"
										+ "</td><td><strong>"
										+ strCheckBoxNames[j + 1]
										+ "</strong></td>" + "</tr>";
							} else {
								strHtml = strHtml
										+ "<tr>"
										+ "<td height='24'><input type='checkbox' name='checkBox' value='"
										+ strCheckBoxValues[j]
										+ "'"
										+ strMatchedFlagsList[j]
										+ "/>"
										+ "</td><td><strong> "
										+ strCheckBoxNames[j]
										+ "</strong></td>"
										+ "<td><input type='checkbox' name='checkBox' value='"
										+ strCheckBoxValues[j + 1] + "'"
										+ strMatchedFlagsList[j + 1] + " />"
										+ "</td><td><strong>"
										+ strCheckBoxNames[j + 1]
										+ "</strong></td>" + "</tr>";
							}
							j = j + 2;
							strHtml = strHtml + "\n";
							i = i + 1;
						}

					}
					if ((i == (strCheckBoxValues.length - 1))
							&& ((strCheckBoxValues.length % 2) != 0)) {
						strHtml = strHtml
								+ "\n<tr>"
								+ "<td height='24'><input type='checkbox' name='checkBox' value='"
								+ strCheckBoxValues[i] + "'"
								+ strMatchedFlagsList[i] + " />"
								+ "</td><td><strong>" + strCheckBoxNames[i]
								+ "</strong></td>" + "</tr>";
					}
				}

			}
		} catch (final Exception e) {
			/*LogTracer.writeTracerLog(className, methodName, e);
			LogTracer.writeExceptionLog(className, methodName, e);*/
		}

		return strHtml;
	}

	public static String getHtmlNewBlock(final ArrayList alResults,
			final String selectName, final String strJSFnName) {
		final String methodName = "getHtmlNewBlock";
		String strHtml = "";
		//LogTracer.writeDebugLog(className, methodName, "Start");

		try {
			if ((alResults != null) && (alResults.size() >= 0)) {
				String[] strIdValue = {};
				// strHtml has been changed a bit for including id in the html
				// select option
				strHtml += ("<select name=\"" + selectName + "\"" + " "
						+ "id=\"" + selectName + "\" " + strJSFnName + ">");
				strHtml += "<option value=\"\"></option>";

				for (int i = 0; i < alResults.size(); i++) {
					strIdValue = (String[]) alResults.get(i);
					strHtml = strHtml + "<option value=\""
							+ strIdValue[0].trim() + "\">"
							+ strIdValue[1].trim() + "</option>";
				}

				strHtml += "</select>";
			}
		} catch (final Exception ex) {
			//LogTracer.writeTracerLog(className, methodName, ex);
		}

		//LogTracer.writeDebugLog(className, methodName, "End");

		return strHtml;
	}

	public static String getHtmlScannerBlock(final ArrayList alResults,
			final String selectName, final String strJSFnName) {
		final String methodName = "getHtmlScannerBlock";
		String strHtml = "";
		//LogTracer.writeDebugLog(className, methodName, "Start");

		try {
			if ((alResults != null) && (alResults.size() >= 0)) {
				String[] strIdValue = {};
				strHtml += ("<select name=\"" + selectName + "\" "
						+ strJSFnName + ">");
				strHtml += "<option value=\"\"></option>";

				for (int i = 0; i < alResults.size(); i++) {
					strIdValue = (String[]) alResults.get(i);
					strHtml = strHtml + "<option value=\""
							+ strIdValue[0].trim() + "\">"
							+ strIdValue[0].trim() + "</option>";
				}

				strHtml += "</select>";
			}
		} catch (final Exception ex) {
			//LogTracer.writeTracerLog(className, methodName, ex);
		}

		//LogTracer.writeDebugLog(className, methodName, "End");

		return strHtml;
	}

	public static String getHtmlvinBlock(final ArrayList alResults,
			final String selectName, final String strJSFnName,
			final String strSelectValue, final String onChangeValue) {
		/*com.vcl.util.LogTracer.writeSOP("strVaues::::::::::" + selectName);*/
		if ((strSelectValue == null) || strSelectValue.equals("")) {
			return getHtmlVINBlock(alResults, selectName, strJSFnName,
					onChangeValue);
		}

		String strHtml = "";
		String strSelected = "";
		final String methodName = "getHtmlBlock";
		//LogTracer.writeDebugLog(className, methodName, "Start");

		try {
			if ((alResults != null) && (alResults.size() > 0)) {
				String[] strIdValue = {};

				strHtml += ("<select name=\"" + selectName + "\" onchange=\""
						+ onChangeValue + "\" " + strJSFnName + ">");
				strHtml += "<option value=\"\"></option>";

				for (int i = 0; i < alResults.size(); i++) {
					strSelected = "";
					strIdValue = (String[]) alResults.get(i);

					if ((strIdValue[0] != null)
							&& !strIdValue[0].equals("null")) {
						strIdValue[0] = strIdValue[0].trim();
					}

					if ((strIdValue[1] != null)
							&& !strIdValue[1].equals("null")) {
						strIdValue[1] = strIdValue[1].trim();
					}

					if (strSelectValue.trim().equals(strIdValue[0])) {
						strSelected = "selected";
					}

					strHtml = strHtml + "<option value=\"" + strIdValue[0]
							+ "\" " + strSelected + " >" + strIdValue[1]
							+ "</option>";
				}
				strHtml = strHtml + "<option value=\"" + "New" + "\">" + "New"
						+ "</option>";
				strHtml += "</select>";
				/*com.vcl.util.LogTracer.writeSOP("html :>>>>" + strHtml);*/
			} else {
				strHtml += ("<select name=\"" + selectName + "\" onchange=\"" + onChangeValue + "\" " + strJSFnName + ">");
				strHtml += "<option value=\"\"></option>";
				strHtml = strHtml + "<option value=\"" + "New" + "\">" + "New" + "</option>";
				strHtml += "</select>";
			}
		} catch (final Exception ex) {
			//LogTracer.writeExceptionLog(className, methodName, ex.getMessage());
		}

		//LogTracer.writeDebugLog(className, methodName, "End");

		return strHtml;
	}

	/*
	 * New methods integrated by Kranthi Chaitanya for QueueManagement and
	 * QueueMapping functionality
	 */

	public static String getHtmlVINBlock(final ArrayList alResults,
			final String selectName, final String strJSFnName,
			final String onChangeValue) {
		final String methodName = "getHtmlVINBlock";
		String strHtml = "";
		//LogTracer.writeDebugLog(className, methodName, "Start");

		try {
			/*com.vcl.util.LogTracer.writeSOP("in html vin block");*/
			if ((alResults != null) && (alResults.size() >= 0)) {
				String[] strIdValue = {};
				strHtml += ("<select name=\"" + selectName + "\" onchange=\""
						+ onChangeValue + "\" " + strJSFnName + ">");
				strHtml += "<option value=\"\"></option>";

				for (int i = 0; i < alResults.size(); i++) {
					strIdValue = (String[]) alResults.get(i);

					if ((strIdValue[0] != null)
							&& !strIdValue[0].equals("null")) {
						strIdValue[0] = strIdValue[0].trim();
					}

					if ((strIdValue[1] != null)
							&& !strIdValue[1].equals("null")) {
						strIdValue[1] = strIdValue[1].trim();
					}
					strHtml = strHtml + "<option value=\"" + strIdValue[0]
							+ "\">" + strIdValue[1] + "</option>";
				}
				strHtml = strHtml + "<option value=\"" + "New" + "\">" + "New"+ "</option>";
				strHtml += "</select>";
				/*com.vcl.util.LogTracer.writeSOP("strhtml:::" + strHtml);*/
			}
		} catch (final Exception ex) {
			/*LogTracer.writeExceptionLog(className, methodName, ex.getMessage());*/
		}

		/*LogTracer.writeDebugLog(className, methodName, "End");*/

		return strHtml;
	}

	public static String getInstaHtmlBlock(final ArrayList alResults,
			final String selectName, final String strJSFnName) {
		final String methodName = "getHtmlBlock";
		String strHtml = "";
		/*LogTracer.writeDebugLog(className, methodName, "Start");*/

		try {
			if ((alResults != null) && (alResults.size() >= 0)) {
				String[] strIdValue = {};
				strHtml += ("<select name=\"" + selectName + "\" "
						+ strJSFnName + ">");
				// strHtml += "<option value=\"\"></option>";

				for (int i = 0; i < alResults.size(); i++) {
					strIdValue = (String[]) alResults.get(i);

					if ((strIdValue[0] != null)
							&& !strIdValue[0].equals("null")) {
						strIdValue[0] = strIdValue[0].trim();
					}

					if ((strIdValue[1] != null)
							&& !strIdValue[1].equals("null")) {
						strIdValue[1] = strIdValue[1].trim();
					}

					strHtml = strHtml + "<option value=\"" + strIdValue[0]
							+ "\">" + strIdValue[1] + "</option>";
				}

				strHtml += "</select>";
			}
		} catch (final Exception ex) {
			/*LogTracer.writeExceptionLog(className, methodName, ex.getMessage());*/
		}

		/*LogTracer.writeDebugLog(className, methodName, "End");*/

		return strHtml;
	}

	public static String getInstaHtmlBlock(final ArrayList alResults,
			final String selectName, final String strJSFnName,
			final String strSelectValue) {

		if ((strSelectValue == null) || strSelectValue.equals("")) {
			return getInstaHtmlBlock(alResults, selectName, strJSFnName);
		}

		String strHtml = "";
		String strSelected = "";
		final String methodName = "getHtmlBlock";
		/*LogTracer.writeDebugLog(className, methodName, "Start");*/

		try {
			if ((alResults != null) && (alResults.size() > 0)) {
				String[] strIdValue = {};

				strHtml += ("<select name=\"" + selectName + "\" "
						+ strJSFnName + ">");
				// strHtml += "<option value=\"\"></option>";

				for (int i = 0; i < alResults.size(); i++) {
					strSelected = "";
					strIdValue = (String[]) alResults.get(i);

					if ((strIdValue[0] != null)
							&& !strIdValue[0].equals("null")) {
						strIdValue[0] = strIdValue[0].trim();
					}

					if ((strIdValue[1] != null)
							&& !strIdValue[1].equals("null")) {
						strIdValue[1] = strIdValue[1].trim();
					}

					if (strSelectValue.trim().equals(strIdValue[0])) {
						strSelected = "selected";
					}

					strHtml = strHtml + "<option value=\"" + strIdValue[0]
							+ "\" " + strSelected + " >" + strIdValue[1]
							+ "</option>";
				}

				strHtml += "</select>";
			}
		} catch (final Exception ex) {
			/*LogTracer.writeExceptionLog(className, methodName, ex.getMessage());*/
		}

		/*LogTracer.writeDebugLog(className, methodName, "End");*/

		return strHtml;
	}
	
	public static String getInstaHtmlBlockOnline(final ArrayList alResults,
			final String selectName, final String strJSFnName,
			final String strSelectValue) {

		if ((strSelectValue == null) || strSelectValue.equals("")) {
			return getInstaHtmlBlock(alResults, selectName, strJSFnName);
		}

		String strHtml = "";
		final String methodName = "getInstaHtmlBlockOnline";
		/*LogTracer.writeDebugLog(className, methodName, "Start");*/

		try {
			if ((alResults != null) && (alResults.size() > 0)) {
				String[] strIdValue = {};

				strHtml += ("<select name=\"" + selectName + "\" id=\"" + selectName + "\" "
						+ strJSFnName + ">");

				for (int i = 0; i < alResults.size(); i++) {
					strIdValue = (String[]) alResults.get(i);

					if ((strIdValue[0] != null)
							&& !strIdValue[0].equals("null")) {
						strIdValue[0] = strIdValue[0].trim();
					}

					if ((strIdValue[1] != null)
							&& !strIdValue[1].equals("null")) {
						strIdValue[1] = strIdValue[1].trim();
					}

					if (strSelectValue.trim().equals(strIdValue[0])) {
					strHtml = strHtml + "<option value=\"" + strIdValue[0]
							+ "\" >" + strIdValue[1]
							+ "</option>";
					}
				}

				strHtml += "</select>";
			}
		} catch (final Exception ex) {
			/*LogTracer.writeExceptionLog(className, methodName, ex.getMessage());*/
		}

		/*LogTracer.writeDebugLog(className, methodName, "End");*/

		return strHtml;
	}

	public static String getLabel4Id(final ArrayList list, final String id,
			final int keyIndex, final int valueIndex) {
		String label = "";
		if ((id == null) || "".equals(id)) {
			return label;
		}
		for (int i = 0; i < list.size(); i++) {
			final String[] details = (String[]) list.get(i);
			if (id.equals(details[keyIndex])) {
				label = details[valueIndex];
				break;
			}
		}
		return label;
	}

	/**
	 * Gets the htmlBlock attribute of the HtmlUtil class
	 * 
	 * @param alResults
	 *            ArrayList
	 * @param selectName
	 *            String
	 * @param strJSFnName
	 *            String
	 * @return The htmlBlock value
	 */
	public static String getProductTypeHtmlBlock(final ArrayList alResults,
			final String selectName, final String strJSFnName) {
		final String methodName = "getProductTypeHtmlBlock";
		String strHtml = "";
		/*LogTracer.writeDebugLog(className, methodName, "Start");*/

		try {
			if ((alResults != null) && (alResults.size() >= 0)) {
				String[] strIdValue = {};
				strHtml += ("<select name=\"" + selectName + "\" "
						+ strJSFnName + ">");
				strHtml += "<option value=\"\"></option>";

				for (int i = 0; i < alResults.size(); i++) {
					strIdValue = (String[]) alResults.get(i);

					if ((strIdValue[0] != null)
							&& !strIdValue[0].equals("null")) {
						strIdValue[0] = strIdValue[0].trim();
					}

					if ((strIdValue[1] != null)
							&& !strIdValue[1].equals("null")) {
						strIdValue[1] = strIdValue[1].trim();
					}
					strHtml = strHtml + "<option value=\"" + strIdValue[0]
							+ "\">" + strIdValue[1] + "</option>";
				}
				strHtml += "<option value=\"99\">Others</option>";

				strHtml += "</select>";
			}
		} catch (final Exception ex) {
			/*LogTracer.writeExceptionLog(className, methodName, ex.getMessage());*/
		}

		/*LogTracer.writeDebugLog(className, methodName, "End");*/

		return strHtml;
	}

	public static String getReqParameterValue(final HttpServletRequest req,
			final String paramName) {
		String paramValue = req.getParameter(paramName);
		if (paramValue == null) {
			paramValue = "";
		}
		return paramValue;
	}

	/**
	 * Gets the htmlBlock attribute of the HtmlUtil class
	 * 
	 * @param alResults
	 *            ArrayList
	 * @param selectName
	 *            String
	 * @param strJSFnName
	 *            String
	 * @param size
	 *            String
	 * @param multiple
	 *            String
	 * @param selValues
	 *            String
	 * @return The htmlBlock value String
	 */
	public static String getSelectedListHtmlBlock(final ArrayList alResults,
			final String selectName, final String strJSFnName,
			final String size, final String multiple, final String selValues,
			final String strSelectValue) {
		String strHtml = "";
		final String methodName = "getHtmlBlock";
		//LogTracer.writeDebugLog(className, methodName, "Start");

		try {
			final StringTokenizer token = new StringTokenizer(selValues.trim(),
					",");
			final HashMap map = new HashMap();
			String strSelected = "";
			while (token.hasMoreTokens()) {
				final String nextToken = token.nextToken().trim();
				map.put(nextToken, nextToken);
			}

			if ((alResults != null) && (alResults.size() > 0)) {
				String[] strIdValue = {};
				strHtml += ("<select name=\"" + selectName + "\" "
						+ strJSFnName + " size=\"" + size + "\" " + multiple + " >");
				strHtml += "<option value=\"\"></option>";
				for (int i = 0; i < alResults.size(); i++) {
					strSelected = "";
					strIdValue = (String[]) alResults.get(i);
					if ((strIdValue[0] != null)
							&& !strIdValue[0].equals("null")) {
						strIdValue[0] = strIdValue[0].trim();
					}

					if ((strIdValue[1] != null)
							&& !strIdValue[1].equals("null")) {
						strIdValue[1] = strIdValue[1].trim();
					}
					if ((strIdValue[2] != null)
							&& !strIdValue[2].equals("null")) {
						strIdValue[2] = strIdValue[2].trim();
					}
					if (map.containsKey(strIdValue[2])) {

						if (strIdValue[0].equals(strSelectValue)) {
							strSelected = "selected";
						}
						strHtml = strHtml + "<option value=\"" + strIdValue[0]
								+ "\" " + strSelected + " >" + strIdValue[1]
								+ "</option>";
					} else {

						alResults.remove(i);
						i--;
						// strHtml = strHtml + "<option value=\"" +
						// strIdValue[0] + "\">" +
						// strIdValue[1] + "</option>";
					}
				}

				strHtml += "</select>";
			}
		} catch (final Exception ex) {
			//LogTracer.writeExceptionLog(className, methodName, ex.getMessage());
		}

		//LogTracer.writeDebugLog(className, methodName, "End");

		return strHtml;
	}

	public static String getTitleHtmlBlock(final ArrayList alResults,
			final String selectName, final String strJSFnName) {
		final String methodName = "getHtmlBlock";
		String strHtml = "";
		//LogTracer.writeDebugLog(className, methodName, "Start");

		try {
			if ((alResults != null) && (alResults.size() >= 0)) {
				String[] strIdValue = {};
				strHtml += ("<select name=\"" + selectName + "\" "
						+ strJSFnName + ">");
				strHtml += "<option value=\"\"></option>";

				for (int i = 0; i < alResults.size(); i++) {

					strIdValue = (String[]) alResults.get(i);
					if ((strIdValue != null) && (strIdValue[0] != null)
							&& !("").equals(strIdValue[0])
							&& !("ACH").equals(strIdValue[0].trim())) {
						strHtml = strHtml + "<option value=\""
								+ strIdValue[0].trim() + "\">"
								+ strIdValue[1].trim() + "</option>";
					}
				}

				strHtml += "</select>";
			}
		} catch (final Exception ex) {
			//LogTracer.writeTracerLog(className, methodName, ex);
		}

		//LogTracer.writeDebugLog(className, methodName, "End");

		return strHtml;
	}

	public static String getTitleHtmlBlock(final ArrayList alResults,
			final String selectName, final String strJSFnName,
			final String onChangeMetod) {
		final String methodName = "getHtmlBlock";
		String strHtml = "";
		//LogTracer.writeDebugLog(className, methodName, "Start");

		try {
			if ((alResults != null) && (alResults.size() >= 0)) {
				String[] strIdValue = {};
				// strHtml += ("<select name=\"" + selectName + "\" " +
				strHtml += ("<select name=\"" + selectName + "\" onchange=\""
						+ onChangeMetod + "\" " + strJSFnName + ">");
				strHtml += "<option value=\"\"></option>";

				for (int i = 0; i < alResults.size(); i++) {
					strIdValue = (String[]) alResults.get(i);

					if ((strIdValue[0] != null)
							&& !strIdValue[0].equals("null")) {
						strIdValue[0] = strIdValue[0].trim();
					}

					if ((strIdValue[1] != null)
							&& !strIdValue[1].equals("null")) {
						strIdValue[1] = strIdValue[1].trim();
					}
					strHtml = strHtml + "<option value=\"" + strIdValue[0]
							+ "\">" + strIdValue[1] + "</option>";
				}

				strHtml += "</select>";
			}
		} catch (final Exception ex) {
			//LogTracer.writeExceptionLog(className, methodName, ex.getMessage());
		}

		//LogTracer.writeDebugLog(className, methodName, "End");

		return strHtml;
	}

	public static String getTitleHtmlBlock4BodyStyle(final ArrayList alResults,
			final String selectName, final String strJSFnName,
			final String onChangeMetod) {
		final String methodName = "getHtmlBlock";
		String strHtml = "";
		//LogTracer.writeDebugLog(className, methodName, "Start");

		try {
			if ((alResults != null) && (alResults.size() >= 0)) {
				String[] strIdValue = {};
				// strHtml += ("<select name=\"" + selectName + "\" " +
				if ((alResults != null) && (alResults.size() == 1)) {
					strHtml += ("<select name=\"" + selectName
							+ "\" onchange=\"" + onChangeMetod + "\" "
							+ strJSFnName + ">");
					// strHtml += "<option value=\"\"></option>";
				} else if ((alResults != null) && (alResults.size() > 1)) {
					strHtml += ("<select name=\"" + selectName
							+ "\" onchange=\"" + onChangeMetod + "\" "
							+ strJSFnName + ">");
					strHtml += "<option value=\"\"></option>";
				}
				for (int i = 0; i < alResults.size(); i++) {
					strIdValue = (String[]) alResults.get(i);

					if ((strIdValue[0] != null)
							&& !strIdValue[0].equals("null")) {
						strIdValue[0] = strIdValue[0].trim();
					}

					if ((strIdValue[1] != null)
							&& !strIdValue[1].equals("null")) {
						strIdValue[1] = strIdValue[1].trim();
					}
					strHtml = strHtml + "<option value=\"" + strIdValue[0]
							+ "\">" + strIdValue[1] + "</option>";
				}

				strHtml += "</select>";
			} else {
				strHtml += ("<select name=\"" + selectName + "\" onchange=\""
						+ onChangeMetod + "\" " + strJSFnName + ">");
				strHtml += "<option value=\"\"></option>";
				strHtml += "</select>";
			}
		} catch (final Exception ex) {
			//LogTracer.writeExceptionLog(className, methodName, ex.getMessage());
		}

		//LogTracer.writeDebugLog(className, methodName, "End");

		return strHtml;
	}

	public static String getTitleHtmlBlock4BodyStyle(final ArrayList alResults,
			final String selectName, final String strJSFnName,
			final String onChangeMetod, final String strSelectValue) {
		final String methodName = "getHtmlBlock";
		String strHtml = "";
		//LogTracer.writeDebugLog(className, methodName, "Start");
		if ((strSelectValue == null) || strSelectValue.equals("")) {
			return getTitleHtmlBlock4BodyStyle(alResults, selectName,
					strJSFnName, onChangeMetod);
		}
		String strSelected = "";
		try {
			if ((alResults != null) && (alResults.size() >= 0)) {
				String[] strIdValue = {};
				// strHtml += ("<select name=\"" + selectName + "\" " +
				if ((alResults != null) && (alResults.size() == 1)) {
					strHtml += ("<select name=\"" + selectName
							+ "\" onchange=\"" + onChangeMetod + "\" "
							+ strJSFnName + ">");
					// strHtml += "<option value=\"\"></option>";
				} else if ((alResults != null) && (alResults.size() > 1)) {
					strHtml += ("<select name=\"" + selectName
							+ "\" onchange=\"" + onChangeMetod + "\" "
							+ strJSFnName + ">");
					strHtml += "<option value=\"\"></option>";
				}

				for (int i = 0; i < alResults.size(); i++) {
					strSelected = "";
					strIdValue = (String[]) alResults.get(i);

					if ((strIdValue[0] != null)
							&& !strIdValue[0].equals("null")) {
						strIdValue[0] = strIdValue[0].trim();
					}

					if ((strIdValue[1] != null)
							&& !strIdValue[1].equals("null")) {
						strIdValue[1] = strIdValue[1].trim();
					}

					if (strSelectValue.trim().equals(strIdValue[0])) {
						strSelected = "selected";
					}

					/*
					 * strHtml = strHtml + "<option value=\"" + strIdValue[0] +
					 * "\">" + strIdValue[1]+ "</option>";
					 */

					strHtml = strHtml + "<option value=\"" + strIdValue[0]
							+ "\" " + strSelected + " >" + strIdValue[1]
							+ "</option>";
				}

				strHtml += "</select>";
			} else {
				strHtml += ("<select name=\"" + selectName + "\" onchange=\""
						+ onChangeMetod + "\" " + strJSFnName + ">");
				strHtml += "<option value=\"\"></option>";
				strHtml += "</select>";
			}
		} catch (final Exception ex) {
			//LogTracer.writeExceptionLog(className, methodName, ex.getMessage());
		}

		//LogTracer.writeDebugLog(className, methodName, "End");

		return strHtml;
	}

	public static String isChecked(final String csvString,
			final String strCheckBoxValue,final String[] mappedList) {
		final String methodName = "isChecked";
		//LogTracer.writeDebugLog(className, methodName, "Start");
		String strChecked = "";
		boolean checkedFlag= false;
		// LogTracer.writeDebugLog(className, methodName, "csvString:" +
		// csvString );
		if (StringUtil.isNotEmptyAndNull(csvString)) {
			final String[] strSelectedl = csvString.split(",");

			for (int i = 0; i < strSelectedl.length; i++) {
				// LogTracer.writeDebugLog(className, methodName, "values:" +
				// strSelectedl[i] + "; " + strCheckBoxValue);
				if (strSelectedl[i].equals(strCheckBoxValue)) {
					strChecked = "checked";
					checkedFlag=true;
					break;
				} 				
			}
		}
		if (mappedList!=null &&  mappedList.length>0) {	
			for (int i = 0; i < mappedList.length; i++) {				
				if (mappedList[i].equals(strCheckBoxValue)) {
					if(!checkedFlag)
						strChecked = strChecked + "disabled";					
					break;
				} 
			}
		}
		//LogTracer.writeDebugLog(className, methodName, "End");
		return strChecked;
	}	

	public static Boolean isDateTime(final String data, final String pattern) {
		final String[] dateParams = data.split(":");
		try {
			if (!((Integer.parseInt(dateParams[0]) > 0) && (Integer
					.parseInt(dateParams[0]) < 24))) {
				return false;
			}
			if (!((Integer.parseInt(dateParams[1]) >= 0) && (Integer
					.parseInt(dateParams[1]) <= 60))) {
				return false;
			}
		} catch (final Exception e) {
			return false;
		}
		return true;
	}

	public static Boolean isDateTimeType(final String data, final String pattern) {
		final int[] monthDays = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31,
				30, 31 };
		if (pattern.equals("MM/DD/YYYY")) {
			if ((data.length() != 10) && (data.indexOf("/") != 2)
					&& (data.indexOf("/") != 5)) {
				return false;
			}
			final String[] dateParams = data.split("/");
			try {
				if (!((Integer.parseInt(dateParams[0]) > 0) && (Integer
						.parseInt(dateParams[0]) < 13))) {
					return false;
				}

				if (!((Integer.parseInt(dateParams[1]) > 0) && (Integer
						.parseInt(dateParams[1]) <= monthDays[Integer
						.parseInt(dateParams[0])]))) {
					return false;
				}

				if (!((Integer.parseInt(dateParams[2]) >= 1900) && (Integer
						.parseInt(dateParams[2]) <= 2100))) {
					return false;
				}
			} catch (final Exception e) {
				return false;
			}
			return true;
		}
		return null;
	}

	/*public String getMessage(final MessageBean messageBean) {
		final String methodName = "getMessage";
		LogTracer.writeDebugLog(className, methodName, "Start");

		final Properties pr = getProperties();
		final String key = messageBean.getKey();
		final Object[] obj = messageBean.getValues();
		String messageValue = "";

		try {
			messageValue = pr.getProperty(key);
		} catch (final Exception exe) {
			LogTracer.writeTracerLog(className, methodName, exe);
		}

		LogTracer.writeDebugLog(className, methodName, "End");

		return MessageFormat.format(messageValue, obj);
	}*/

	/*public String getProductErrorMessage(final MessageBean messageBean) {
		final String methodName = "getProductErrorMessage";
		LogTracer.writeDebugLog(className, methodName, "Start");

		final Properties pr = getProperties();
		final String key = messageBean.getKey();
		final Object[] obj = messageBean.getValues();
		String messageValue = "";

		try {
			messageValue = pr.getProperty(key);
		} catch (final Exception exe) {
			LogTracer.writeTracerLog(className, methodName, exe);
		}

		LogTracer.writeDebugLog(className, methodName, "End");

		return MessageFormat.format(messageValue, obj);
	}*/

	/*public String getProductMessage(final MessageBean messageBean) {
		final String methodName = "getProductMessage";
		LogTracer.writeDebugLog(className, methodName, "Start");

		final Properties pr = getProperties();
		final String key = messageBean.getKey();
		final Object[] obj = messageBean.getValues();
		String messageValue = "";

		try {
			messageValue = pr.getProperty(key);
		} catch (final Exception exe) {
			LogTracer.writeTracerLog(className, methodName, exe);
		}

		LogTracer.writeDebugLog(className, methodName, "End");

		return "<li>" + MessageFormat.format(messageValue, obj) + "</li>";
	}*/

	public Properties getProperties() {
		final String methodName = "getProperties";
		//LogTracer.writeDebugLog(className, methodName, "Start");

		final Properties pr = new Properties();

		try {
			pr.load(this.getClass().getResourceAsStream(
					"/ApplicationResources.properties"));
		} catch (final Exception exe) {
			/*LogTracer
					.writeExceptionLog(className, methodName, exe.getMessage());*/
		}

		//LogTracer.writeDebugLog(className, methodName, "End");

		return pr;
	}

	public static String getWeekDay(int day) throws Exception {
		String methodName = "getDayOfWeek";
		String dayOfWeek = "";

		switch (day) {
		case 0:
			dayOfWeek = "SAT";
			break;
		case 1:
			dayOfWeek = "SUN";
			break;
		case 2:
			dayOfWeek = "MON";
			break;
		case 3:
			dayOfWeek = "TUE";
			break;
		case 4:
			dayOfWeek = "WED";
			break;
		case 5:
			dayOfWeek = "THU";
			break;
		case 6:
			dayOfWeek = "FRI";
			break;
		default:
			break;
		}

		return dayOfWeek;
	}

	public static String getRepoStatusHtmlBlock(ArrayList alResults,
			String selectName, String strJSFnName, String strSelectValue) {
		if ((strSelectValue == null) || strSelectValue.equals("")) {
			return getHtmlBlock(alResults, selectName, strJSFnName);
		}
		String strHtml = "";
		String strSelected = "";
		String methodName = "getHtmlBlock";
		try {
			if ((alResults != null) && (alResults.size() > 0)) {
				String[] strIdValue = {};
				strHtml += ("<select name=\"" + selectName + "\" "
						+ strJSFnName + ">");
				strHtml += "<option value=\"\">Select</option>";
				for (int i = 0; i < alResults.size(); i++) {
					strSelected = "";
					strIdValue = (String[]) alResults.get(i);
					if (strIdValue[0] != null && !strIdValue[0].equals("null")) {
						strIdValue[0] = strIdValue[0].trim();
					}
					if (strIdValue[1] != null && !strIdValue[1].equals("null")) {
						strIdValue[1] = strIdValue[1].trim();
					}
					if (strSelectValue.trim().equals(strIdValue[0])) {
						strSelected = "selected";
					}
					strHtml = strHtml + "<option value=\"" + strIdValue[0]
							+ "\" " + strSelected + " >" + strIdValue[1]
							+ "</option>";
				}
				strHtml += "</select>";
			}
		} catch (Exception ex) {
			//LogTracer.writeExceptionLog(className, methodName, ex);
		}
		return strHtml;
	}
	/*public String getErrorMessage(ValidateError validateError) {
        String methodName = "getMessage";
        LogTracer.writeDebugLog(className, methodName, "Start");

        Properties pr = getProperties();
        String key = validateError.getKey();
        Object[] obj = validateError.getValues();
        String messageValue = "";

        try {
            messageValue = pr.getProperty(key);
        } catch (Exception exe) {
            LogTracer.writeTracerLog(className, methodName, exe);
        }

        LogTracer.writeDebugLog(className, methodName, "End");

        return MessageFormat.format(messageValue, obj);
    }*/
	/*public static HtmlUtilInterface generate() throws Exception {
		HtmlUtilInterface hui = null;

		hui = new HtmlUtilBuilder();

		return hui;
	}*/
}