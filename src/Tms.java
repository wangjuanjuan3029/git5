package com.briup.home01;
import java.util.Scanner;
/**
 *这是一个教师信息管理系统
 */
public class Tms {
	private int index=0;//统计教师个数
	private Teacher[] teas= new Teacher[5];//存储教师信息

	public static void main(String[] args){
		
		Tms tms = new Tms();
		tms.menu();
		Scanner scanner = new Scanner(System.in);

		while(true){
			System.out.print("请输入功能编号：");
			String option = scanner.nextLine();

			switch(option){
				case "1":

					System.out.println("以下为所有学生信息：");
					Teacher[] teas = tms.findAll();
					for(int i=0;i<teas.length;i++){
						System.out.println(teas[i]);
					}
					System.out.println("总共有："+tms.index+"个老师！");//这个地方要用tms.index.否则会报错
					break;
				case "2":
					while(true){
					System.out.println("请输入要添加的老师id#name#gender#age：输入break返回上一级");//long id,String name,String gender,int age
					String teaStr=scanner.nextLine();
					if(teaStr.equals("break")){
						break;
					}
					String[] teaArr=teaStr.split("#");//split不是spilt
				    long id = Long.parseLong(teaArr[0]);
					String name = teaArr[1];
					String gender = teaArr[2];
					int age = Integer.parseInt(teaArr[3]);
				    Teacher tea = new Teacher(id,name,gender,age);
					tms.save(tea) ;
					System.out.println("添加成功");
					}
					
					break;
				case "3":
					System.out.println("请输入要删除的老师id:或break返回上一级目录！");
					String idStr = scanner.nextLine();
					
					if(idStr.equals("break")){
						break;
					}
					long id = Long.parseLong(idStr);
					 Teacher tea =tms.findById(id);
					 if(tea ==null){
						System.out.println("您要删除的教师不存在！");
					 }
					 tms.deleteById(id);
					 System.out.println("删除成功！");

					break;
				case "4":
					
					break;
				case "5":
					while(true){
					System.out.print("请输入要查询的老师id:或输入break返回上一级目录！");
					String idStr5=scanner.nextLine();
					if(idStr5.equals("break")){
						break;
					}
					long id5 = Long.parseLong(idStr5);
					Teacher tea5=tms.findById(id5);
					System.out.println(tea5==null?"sorry no find!":tea5);
					}
					break;
				case "exit":
					System.out.println("欢迎再次使用系统");
					System.exit(0);
					break;
				case "help":
					tms.menu();
					break;

			
			}
		}

	}
	//菜单
	public void menu(){
		System.out.println("*******教师管理系统*******");
		System.out.println("***1.查询所有教师信息");
		System.out.println("***2.添加教师信息");
		System.out.println("***3.删除教师信息");
		System.out.println("***4.修改教师信息");
		System.out.println("***5.根据学号查询教师信息");
		System.out.println("***exit.退出系统系统");
		System.out.println("***help.帮助");
		System.out.println("***************************");

	}
	private int findIndexById(long id){
		int num=-1;
		for(int i=0;i<teas.length;i++){
			if(id==teas[i].getId()){
				num=i;
				break;
			}
		}
		return num;
	}
	//保存教师信息
	public void save(Teacher tea){
		if(index>teas.length){
		Teacher teasDome[] = new Teacher[index+5];
		System.arraycopy(teasDome,0,teas,0,index);
	    teas= teasDome;
		}
		 teas[index++]=tea;
	}
	//删除信息
	public void deleteById(long id){
		int num = findIndexById(id);
		for(int i=num;i<index-1;i++){
			teas[i]=teas[i+1];
		}
		teas[--index]=null;
	}
	//修改信息
	public void update(long id){
	
	}
	//查询所有
	public Teacher[] findAll(){
		Teacher[] teasDemo = new Teacher[index];  
		System.arraycopy(teas,0,teasDemo,0,index);//拷贝：要用System--arraycopy都是小写
		return teasDemo;
	}
	//查询某一个教师信息
	public Teacher findById(long id){
		int num=findIndexById(id);
		return num ==-1?null:teas[num] ;
	}
}