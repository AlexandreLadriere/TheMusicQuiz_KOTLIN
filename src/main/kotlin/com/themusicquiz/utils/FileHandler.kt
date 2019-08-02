/*
 * @Author: Alexandre Ladrière 
 * @Date: 2019-07-31 20:01:12 
 * @Last Modified by: Alexandre Ladrière
 * @Last Modified time: 2019-08-02 16:25:29
 */
package com.themusicquiz.utils;

import com.themusicquiz.components.Item;

abstract class FileHandler {
    companion object {
        public fun readFileFromResources(path: String) = this::class.java.getResource(path).readText(Charsets.UTF_8);
        
        public fun getItemListFromDB(pDBPath: String): MutableList<Item> {
            var tmpDBStr: String = readFileFromResources(pDBPath);
            val itemList: MutableList<Item> = mutableListOf<Item>();
            val fileDir: String = getParentFromString(pDBPath);
            var line: String = "";
            val separator: String = " ||| "; // /!\ not the same as in java: " \\|\\|\\| "
            var splitLine: List<String>;
            for(character in tmpDBStr) {
                if(character == '\n') {
                    splitLine = line.split(separator);
                    itemList.add(Item(splitLine[0], splitLine[1], splitLine[2], splitLine[3], fileDir+"covers/"+splitLine[4]+".jpeg", fileDir+"summaries/"+splitLine[4]+".txt"));
                    line = "";
                }
                else {
                    line += character;
                }
            }
            return itemList;
        }
    }
}
