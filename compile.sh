# @Author: Alexandre Ladrière 
# @Date: 2019-07-31 16:06:11 
# @Last Modified by:   Alexandre Ladrière 
# @Last Modified time: 2019-07-31 16:06:11 
UTILS_PATH='src/main/kotlin/com/themusicquiz/utils/*kt'
ENUM_PATH='src/main/kotlin/com/themusicquiz/enumerations/*kt'
EXT_PATH='src/main/kotlin/com/themusicquiz/extensions/*kt'
COMP_PATH='src/main/kotlin/com/themusicquiz/components/*kt'
RES_PATH='src/main/resources/'

#EXT_PATH and ENUM_PATH empty for the moment
#for building .jar (without resources):
#kotlinc $UTILS_PATH $COMP_PATH -include-runtime -d TheMusicQuiz.jar

#to compile without making a jar:
kotlinc $UTILS_PATH $ENUM_PATH $COMP_PATH -d ./target/bin