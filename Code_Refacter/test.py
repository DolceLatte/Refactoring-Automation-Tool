temp = not 1

array_a = [1, 2, 3, 4]
array_b = [2, 3, 4, 5]

sum_a = 0

for i in array_a:
    sum_a += i

def Test():
    return "Test"

average_a = sum_a / 4

sum_b = 0

class Calculator:
    def __init__(self):
        self.result = 0

    def add(self, num):
        self.result += num
        return self.result

cal1 = Calculator()

for i in array_b:
    sum_b += i

average_b = sum_b / 4

print(cal1.add(3))
print(average_a)
print(average_b)
