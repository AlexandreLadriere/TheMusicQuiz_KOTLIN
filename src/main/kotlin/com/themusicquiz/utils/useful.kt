/*
 * @Author: Alexandre Ladrière 
 * @Date: 2019-08-02 11:19:39 
 * @Last Modified by: Alexandre Ladrière
 * @Last Modified time: 2019-08-02 11:20:06
 */
package com.themusicquiz.utils;

fun getParentFromString(path: String): String {
    if(path == "") {
        return "";
    }
    else {
        val tmpSplitStr: List<String> = path.split("/");
        var returnStr: String = "";
        for(i in 0..tmpSplitStr.count()-2) {
            returnStr += tmpSplitStr.get(i)+"/";
        }
        return returnStr;
    }
}