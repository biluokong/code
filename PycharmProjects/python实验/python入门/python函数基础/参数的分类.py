# 1、必选参数：调用时是必需要传入相应的值给参数的
def number_sum1(num1, num2):
    num_sum = num1 + num2
    print(num_sum)
    pass


# 函数调用
number_sum1(4, 8)


# 2、默认参数(缺省参数)，始终只能存在参数列表的尾部（即默认参数不能有间隔）
def number_sum2(num1=20, num2=12):
    print("默认参数=%d" % (num1 + num2))
    pass


# 默认参数调用
number_sum2()  # 结果为32
number_sum2(10)  # 结果为22
number_sum2(10, 30)  # 结果为40


# 可变长参数类型（当参数的个数不确定时使用，比较灵活），在函数体内，可变关键字是一个元组类型
def number_sum3(*args):
    print(args)
    result = 0
    for item in args:
        result += item
        pass
    print('result=%d' % result)
    pass


# 3、可选参数函数调用
number_sum3(1)  # 输出结果为（1，），说明可变参数默认会把传入的参数作为元组类型的元素
number_sum3(1, 3, 4, 5)  # 输出结果为（1,3，4，5）


# number_sum3((1, 2), (2, 4))     # 元组能作为参数，但累加的时候会有问题
# number_sum3({"name": "张三"}, {"age": "23", 4: 4})  # 字典可以作为参数，但累加的时候会有问题
# number_sum3([1, 3, 4])  # 列表也可作为参数，但累加的时候会有问题


# 关键字可选参数，用**来定义，在函数体内，参数关键字是一个字典类型，key必须是一个字符串
def key_Fun(**kwargs):
    print(kwargs)
    pass


# 关键字可选参数调用
# key_Fun(1, 2, 3)  不可以传递
# 第一种传参方式，通过直接传入字典类型
dict1 = {"name": "张三", "age": "12"}
key_Fun(**dict1)
# 第二种传参方式，通过键值对
key_Fun(name='李四', age="23")
# 不传也可以
key_Fun()  # 输出为{}


# 4、既有可选参数又有关键字可选参数(组合的使用)。注意：可选参数必须放在关键字可选参数之前，不然会报错。
def complex_Fun(*args, **kwargs):
    print(args)
    print(kwargs)
    pass


# 调用
complex_Fun(1, 2, 3, 4)  # 输出了（1,2,3,4）{}
complex_Fun(1, 2, 3, 4, name='光头强')  # 输出了（1,2,3,4） {‘name': '光头强'}
complex_Fun(name='光头强')  # 也可以只给后边的，输出了（）{’name': '光头强'}
