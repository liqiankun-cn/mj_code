package com.for22.mjcp.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * 设计一种方法，将一个字符串中的所有空格替换成 %20 。你可以假设该字符串有足够的空间来加入新的字符，且你得到的是“真实的”字符长度。你的程序还需要返回被替换后的字符串的长度。

 注意事项:
 如果使用 Java 或 Python, 程序中请用字符数组表示字符串。

 挑战：
 在原字符串(字符数组)中完成替换，不适用额外空间

 格式：

 输入行第一行输入一个字符串，最后输出替换后的字符串和长度。

 样例输入

 "Mr John Smith"

 样例输出

 "Mr%20John%20Smith"
 17
 *
 *
 * @author lx
 * @Description:
 * @Date 2018/1/8
 */
public class ReplaceSpace {

    public static int replaceSpace(char[] param,int length){
        List<Integer> index = new ArrayList<>();
        for(int i= 0;i<length;i++){
            if(param[i] == ' '){
                index.add(i);
            }
        }
        int indexLength = index.size();
        for(int j = indexLength-1;j>=0;j--){
            int tem = j*2+2;
            int endIndex = j == indexLength -1 ? length-1:  index.get(j+1)-1;
            for(int k = endIndex;k>index.get(j);k--){
                param[k+tem] = param[k];
            }
            param[index.get(j)+tem] = '0';
            param[index.get(j)+tem-1] = '2';
            param[index.get(j)+tem-2] = '%';
        }
        return length+indexLength*2+2;
    }

    public static void main(String[] args) {
        String a = "Instantly translate your text from one language to another with Bing Translator. Powered by Microsoft Translator, the site provides free translation to and";
        char[] param = Arrays.copyOf(a.toCharArray(),a.length()*2);

        replaceSpace(param,a.length());
        for(int i = 0;i<param.length;i++){
            System.out.print(param[i]);
        }
    }
}
 