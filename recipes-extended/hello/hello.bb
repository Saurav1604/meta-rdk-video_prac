SUMMARY = "Hello world program"
LICENCE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d41d8cd98f00b204e9800998ecf8427e"

SRC_URI = "files://hello.c \
            files://LICENSE"
S = "${Workdir}" //build inside temp work dir

do_compile(){
    ${CC} hello.c -o hello //${CC} is Yocto's compiler(gcc or cross-gcc)
}

do_install(){
    install -d ${D}${bindir}
    install -m 0755 hello ${D}${bindir} 
    
}/*0755 - 0 is for special byte, 7(owner's) = 4+2+1(write+read+execute),
5 - group and 5 is for others. 5 = 4+1(read+execute)
if u use 0644 u will get error since u wont be able to execute*/
do_install:append() {
    echo "Hello installed by bbappend"
}

RPROVIDES:${PN} += "hello-app"

