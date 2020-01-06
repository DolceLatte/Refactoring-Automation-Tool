"""
DocString
"""
class Calculator:
    '''
    DocString In Class
    '''
    def __init__(self):
        '''
        DocString In Function
        '''
        self.result = 0

    def add(self, num):
        self.result += num
        return self.result

cal1 = Calculator()

print(cal1.add(3))
