# -*- coding: utf-8 -*-
def decorator_function(original_function):
	def wrapper_function():
		print('{} 함수가 호출되기전 입니다.'.format(original_function.__name__))
		return original_function()
	return wrapper_function


@decorator_function  #1
def display_1():
	print('display_1 함수가 실행됐습니다.')


@decorator_function  #2
def display_2():
	print('display_2 함수가 실행됐습니다.')

# display_1 = decorator_function(display_1)  #3
# display_2 = decorator_function(display_2)  #4

display_1()
display_2()
