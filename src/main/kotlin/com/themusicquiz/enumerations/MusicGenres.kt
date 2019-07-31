/*
 * @Author: Alexandre Ladrière 
 * @Date: 2019-07-31 17:58:22 
 * @Last Modified by: Alexandre Ladrière
 * @Last Modified time: 2019-07-31 18:08:20
 */
package com.themusicquiz.enumerations;

enum class MusicGenres(val musicGenre_toDisplay: String, val musicGenre_name: String, val musicGenreLanguage_toDisplay: String, val musicGenreLanguage_name: String) {
    US_hiphop("Hip-hop", "hiphop", "US hip-hop", "US_hiphop"), 
    FR_hiphop("Hip-hop", "hiphop", "FR hip-hop", "FR_hiphop");
}