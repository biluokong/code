name = "全局变量"


def func1():
    name = "局部变量1"
    print(name)


def func2():
    global name
    name = '修改后的全局变量'


def func3():
    name = '局部变量2'
    print(name)


# 调用函数
func1()
print(name)
func2()
print(name)
func3()
print(name)