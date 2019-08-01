UTILS_PATH='src/main/kotlin/com/themusicquiz/utils/*kt'
ENUM_PATH='src/main/kotlin/com/themusicquiz/enumerations/*kt'
EXT_PATH='src/main/kotlin/com/themusicquiz/extensions/*kt'
COMP_PATH='src/main/kotlin/com/themusicquiz/components/*kt'
RES_PATH='src/main/resources/'
DEST_PATH='./target/bin'

#for building .jar (without resources):
#kotlinc $UTILS_PATH $COMP_PATH -include-runtime -d TheMusicQuiz.jar

#to compile without making a jar:
kotlinc $UTILS_PATH $ENUM_PATH $COMP_PATH -d $DEST_PATH