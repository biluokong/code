"""
流程：计算机执行代码的顺序
流程控制：对计算机代码执行的顺序进行有效的管理，只有流程控制才能实现在开发当中的业务逻辑
流程的分类：顺序流程、选择流程/分支流程、循环流程
"""

'''
选择流程：
if 条件表达式：
    语句块
elif 条件表达式：
    语句块

else：
    语句块
    pass
    
pass：可以让选择/循环语句/函数内的语句块内容结束
让下一语句与选择语句块的语句缩进不同也可以达到pass的效果
条件表达式：比较运算符/逻辑运算符/符合的运算符
'''

print('选择流程：')
score = float(input('请输入您的分数：'))
if score > 90:
    print("您太棒了！")
elif score > 60:
    print('您的成绩不错，但还需要继续努力！')
else:
    print("您的成绩不合格！")

# 或这样写

if score > 90:
    print("您太棒了！")
    pass
elif score > 60:
    print('您的成绩不错，但还需要继续努力！')
    pass
else:
    print("您的成绩不合格！")
    pass
'''
循环流程：
while 条件表达式：
    语句块
    
for 自定义一个变量名 in 可迭代的集合对象：    遍历集合中的每个值，可以用自定义的变量名使用遍历的每个值
    语句块

特别的：
while 条件表达式：
    语句块
else:
    语句块
    
for 自定义一个变量名 in 可迭代的集合对象
    语句块
else:
    语句块
    
else: 循环语句执行完后，若执行过程中执行了break语句，则else：后面的内容就不会被执行；若没有执行过break语句，则else后面的语句会被执行。
    
print(end = '字符串')：end='字符串'表示当前输出语句输出完字符串内容后不换行，若没有end，默认输出完后换行
    
range函数：可以生成一个数据集合
    语法：range(起始,结束,步长) 步长不能为0，否则报错  （输出[起始，结束)中间间隔步长的所有值，步长不能负值，否则无效；若只有结束，默认0为起始）
    
特别的 
    使用列表解析取出非空字符串  
    non_empty_strings = [s for s in str_array if s != '']    
'''
row = 1
while row <= 7:
    j = 1
    while j <= row:
        print(end='*')
        j += 1
        pass
    row += 1
    print()
    pass

tags = "我是一个中国人"    # 字符串是字符类型的集合
for ch in tags:
    print(ch)
    pass

print(type(range(1, 10)))
for data in range(1, 10):
    print(data, end=" ")
print('------------------------')
for d in range(-5, 0, 2):
    print(d, end=" ")

print('--------------')

for i in range(3):
    if i > 1:
        continue
    print(i)
    pass
else:
    print('没有break')

# for...else可以用于下列场景
print('用户登录：')
username = '张三'
passWord = '123'
for i in range(3):
    un = input('请输入用户名：')
    pw = input('请输入密码：')
    if un == username and passWord == pw:
        print('登录成功！')
        break
    print('登录失败！')
else:
    print('你已登录失败3次，你的账号已被锁定！')
