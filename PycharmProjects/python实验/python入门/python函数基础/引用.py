i = 10  # int类型是不可变类型


# 当把i的引用传给函数的形参后，在函数内赋值，会开辟新的内存空间给形参，此时i和num存放的内存地址不一样了
def fun(num):
    print('num存放的内存地址为：', id(num))
    num = 12
    print('对num赋新值后，num存放的内存地址为：', id(num))
    pass


print('i存放的内存地址为：', id(i))
fun(i)
print('调用了fun函数后，i存放的内存地址为：', id(i))

print('-----------------------------------------')
li = [12]  # 列表是可变类型


def func(num):
    print('num存放的内存地址为：', id(num))
    num = [12, 34]
    print('对num赋新值后，num存放的内存地址为：', id(num))
    li.append(12, 34)
    print('修改li中的数据后，li存放的内存地址为；', id(li))
    pass


print('li存放的内存地址为：', id(li))
fun(li)
print('调用函数修改li中的数据后，li存放的内存地址为：', id(li))
print('________________________')


def fun_c():
    li = [12, 34]
    print('对li赋新值后，li存放的内存地址为：', id(li))
    pass


print('li存放的内存地址为：', id(li))
fun_c()
print('调用函数后li的内存地址为：', id(li))
