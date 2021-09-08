# DataStructure-CollegeProject
Project created to use common data structures to create a little system to read books datas

### **What structures where used?**
The main goal of this project, whas to create a system to read data from a file, with the best perfomance possible. There is a lot of ways of doing that, here, were used these guys:

- List
- ArrayList
- HashSet
- HashMap
- TreeMap

It wasn't measured the efficiency of the methods (~~actually, I think it was, i just lost the data~~), but i garantee to you that every single one of them, has a purpose. As an example, the HashSet was used to provide us all the distinct words from each book.

### **That's nice, but how do I run the app?**

Well, it's pretty easy actually. You just need books, and a IDE that runs Java. 

- Books

First of all, you need some books, in .txt format, to run the code. It's higly recommended to use books without any kind of accentuation or special characters, because the code doesn't clean the files ~~yet~~. After you got the books, and have put them in a folder, you have to link them on the code, in line 34:

``` 
File directoryPath = new File("C:\\Users\\Pichau\\Documents\\UTF\\Estrutura de dados\\Trabalho FinalED\\livros");
```
Replace the path with your folder, and it is all set. Here are some books that you can use, all of them were downloaded at [Gutenberg Project](https://www.gutenberg.org).

[livros.zip](https://github.com/Theusaopia/DataStructure-CollegeProject/files/7131139/livros.zip)

- APP

Now that you linked your books, and opened the code on your favorite IDE, just run the Application.java and it's all good :D

### **It doesn't work, now what?**

Yep, i know, it's a little confusing to know what the app is doing. First of all, it wasn't created a proper front-end page, or a menu to separate each method. All of the methods that you can test, are in this range of lines: 71 - 115. If you want to test some method, just find the the "tester" and uncomment it. I know, it's hard, but it's all we got.

### **Final considerations**

I'm going to be honest, the project it's very complicaded to understand. When I coded this little monster, we were kind of short timed in college, and I didn't have the time to think in a beatiful front-end, or menu, i needed to make it work. 

It works? Yes, but isn't 100%, and the results of the methods could be incorrect. But, besides all that, i learned a lot doing this little monster, not only the data structures that I used, but also a little more about Java. 

I'll try to work on this project sometime, improve it, and redesign this monster, so he still can be scary, but a little more prettier. 
