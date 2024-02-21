# 1、返回列表
def _Sum(num):
    li = []
    i = 1
    result = 0
    while i <= num:
        result += i
        i += 1
        li.append(result)
        pass
    return li
    pass


# 调用函数
li = _Sum(5)
print(type(li))
print(li)


# 2、返回元组或字典
def return_Tuple():
    """
    返回元组或字典类型的数据
    :return:
    """
    # return 1, 2, 3
    return {'name': 'aaa'}


# 调用函数
tu = return_Tuple()
print(type(tu))
print(tu)


# 3、返回多个返回值(其实还是返回元组)
def return_Types():
    return {'name': '张三'}, 3.4, (1, 3, 4)


# 调用函数
print(return_Types())
