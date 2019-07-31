/*
 * @Author: Alexandre Ladrière 
 * @Date: 2019-07-31 20:01:12 
 * @Last Modified by: Alexandre Ladrière
 * @Last Modified time: 2019-07-31 20:42:00
 */
package com.themusicquiz.utils;

abstract class FileHandler {
    companion object {
        public fun readFileFromResources(path: String) = this::class.java.getResource(path).readText(Charsets.UTF_8);
    }
}
