"""
猜年龄游戏：
    用户最大试3次
    当3次尝试完，询问用户是否还想继续玩，如果回答y/Y，则继续让用户玩3次，以此往复；若回答n/N，则退出游戏
    如果猜对了，直接退出游戏
"""
from random import random

flag = False
age = int(random() * 100 + 1)
while not flag:
    for i in range(3):
        guess = int(input('请输入您所猜的年龄：'))
        if guess == age:
            print('恭喜您猜对了！')
            flag = True
            break
            pass
        elif guess > age:
            print('您猜的年龄太大了！')
        else:
            print('您猜的年龄太小了！')
    select = input('您是否还想玩，输入y/Y or n/N：')
    if select == 'n' or select == 'N':
        print('游戏失败！')
        break
