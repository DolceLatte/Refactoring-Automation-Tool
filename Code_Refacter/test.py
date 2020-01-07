"""
DocString In Module
"""
class Calculator:

    def __init__(self):
        
        self.result = 0
    def add(self, num):
        """
        DocString In Function
        """
        self.result += num
        return self.result

def test():
    """
    DocString In Function
    """
    pass

for a in Calculator:
    pass

