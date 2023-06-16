g++ -o libfixXInitThreads.so  -shared -fPIC -Wl,-soname,libxx.so -L/usr/lib/X11 -I/usr/include/X11 fixXInitThreads.cpp -lX11

find src/main/java -name '*.java' >s 

 javac -d classes -cp libs/jsfml.jar @s

