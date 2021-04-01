package com.example.leetcode.hangdian;


/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-22 9:11
 */
public class Main2093 {


    /**
     * 太麻烦了不想写
     */
    /**
     * #include<iostream>
     #include<algorithm>
     #include<iomanip>
     using namespace std;
     struct Student{
     char name[11];
     int solve;
     int time;
     }data[10000];//定义结构体数组！！！
     bool cmp(const Student &a,const Student &b)//sort比较函数用来，排序！！！
     {
     if(a.solve!=b.solve)
     if(a.solve>b.solve)
     return true;
     else
     return false;
     else if(a.time!=b.time)
     return a.time<b.time;
     else
     return (strcmp(a.name,b.name)<0);
     }


     int main()//主函数！！
     {
     int n,m,k=0,i,l;
     cin>>n>>m;
     memset(data,0,sizeof(data));//memeset()函数对数组进行清零！！！
     while(cin>>data[k].name)
     {

     for(i=0;i<n;i++)
     {
     int s;
     char ch;
     cin>>s;
     if(s<=0)
     continue;
     data[k].solve++;
     data[k].time+=s;
     if(getchar()=='(')
     {
     cin>>l;
     cin>>ch;
     data[k].time+=l*m;
     }
     }
     k++;//输入数据！！！
     }
     sort(data,data+k,cmp);//排序！
     for(i=0;i<k;i++)
     cout<<left<<setw(10)<<data[i].name<<' '<<right<<setw(2)<<data[i].solve<<' '<<setw(4)<<data[i].time<<endl;
     return 0;//按要求的格式输出！！关于此处的疑问可参考：http://www.cnblogs.com/xiohao/archive/2012/11/26/2789763.html
     }
     */
}
