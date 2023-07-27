#With open as for genome loop
#Notes remember that if you use  just var=open(r"path",r), you will have to later close it var.close() but open with eliminates this need
##Run txt file in python # use w to write
with open(r'C:\Users\tomsuare\Desktop\Fast Folder\pythontom.txt', 'w') as f:
    count = 0
    while count<=5:
        if (count % 2 == 0):
            f.write("YYXX")
            f.write("\t Gene "+str(count)+"\n")
        
        else:
            f.write("XXYYY")
            f.write("\t Gene " + str(count) + "\n")
        count += 1
    #r to read open to read
with open(r'C:\Users\tomsuare\Desktop\Fast Folder\pythontom.txt', 'r') as f:
    contents = f.read()
    print(contents)
