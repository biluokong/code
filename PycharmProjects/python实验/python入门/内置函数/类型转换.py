# 数组转字符，用一个范围在range（256）内的（就是0~255）整数作参数，返回任意一个相应的字符：chr(i）
# i——可以是10进制也可以是16进制的数字；返回值是当期整数对应的ascii字符

# 转为布尔类型，将给定参数转换为布尔类型，如果没有参数，返回False：class bool([x])
# x——要进行转换的参数；返回值：返回True或False
# []、()、{}、0、None、0.0都相当于False

# 转换为二进制：bin(x)
# x——int或者long int数字；返回字符串

# 转换为16进制：hex(x)
# x——10进制整数；返回字符串

# 将元组或字符串转换为列表：list(tup)
# 将列表或字符串转换为元组：tuple(list)
tuple1 = (1, 3, 4)
print(list(tuple1))
print(list('hello tomcat'))
print(tuple([1, 3, 4]))
print(tuple('小猫咪'))

# 创建字典：dict()
'''
语法：
    class dict(**kwarg)
    class dict(mapping, **kwarg)
    class dict(iterable, **kwarg)
参数：
    **kwarg——关键字
    mapping——元素的容器
    iterable——可迭代对象
返回值：一个字典
'''
dic = dict()
print(dic)
dic['name'] = '小米'
dic['age'] = '23'
print(dic)
print(dict(name='小米', age="32"))

# 转换为字节数组：bytes()
'''
描述：bytes()方法返回一个新字节数组，这个数组里的元素是可变的，并且每个元素的值范围：0<=x<256
语法；class bytearray([source[, encoding[, errors]]])
参数：
    source为整数，则返回一个长度为source的初始化数组
    source为字符串，则按指定的encoding将字符串转换为字节序列
    source为可迭代类型，则元素必须为[0, 255]中的整数
    source为与buffer接口一致的对象，则此对象也可以被用于初始化bytes
    如果没有任何参数，默认就是参数化数组W为0个元素
返回值：返回新字节数组
'''
print(bytes('我喜欢python', encoding='utf-8'))
