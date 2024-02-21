package javase基础封装继承和多态.day18;
/*某公司的雇员分为以下若干类：
	Employee：这是所有员工总的父类，
		属性：
			员工的姓名,员工的生日月份。
		方法：getSalary(intmonth)
			根据参数月份来确定工资，如果该月员工过生日，则公司会额外奖励100 元。

	SalariedEmployee：
		Employee 的子类，拿固定工资的员工。
		属性：月薪

	HourlyEmployee：
		Employee 的子类， 按小时拿工资的员工，每月工作超出160 小时的部分按照1.5 倍工资发放。
		属性：每小时的工资、每月工作的小时数

	SalesEmployee：
		Employee 的子类，销售人员，工资由月销售额和提成率决定。
		属性：月销售额、提成率

	BasePlusSalesEmployee：
		SalesEmployee 的子类，有固定底薪的销售人员，工资 由底薪加上销售提成部分。
		属性：底薪。

	根据要求创建 SalariedEmployee 、 HourlyEmployees 、SaleEmployee 和 BasePlusSalesEmployee四个类的对象各一个，
	并计算某个月这四个对象的工资。

	注意：要求把每个类都做成完全封装，不允许非私有化属性。*/
public class test {
    public static void main(String[] args) {
        SalariedEmployee salariedEmployee = new SalariedEmployee("张三", 4, 5000);
        HourEmployee hourEmployee = new HourEmployee("李四", 7, 50, 100);
        SalesEmployee salesEmployee = new SalesEmployee("王五", 8, 100000, 0.05);
        BasePlusSalesEmployee basePlusSalesEmployee = new BasePlusSalesEmployee("吴柳", 1, 100000, 0.02, 5000);
        double sum = salariedEmployee.getSalary(4) + hourEmployee.getSalary(5) + salesEmployee.getSalary(6) + basePlusSalesEmployee.getSalary(9);
        System.out.println("四人的总工资为：" + sum);
    }
}
