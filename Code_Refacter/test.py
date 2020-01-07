"""
DocString In Module
"""
class Calculator:
    """
    DocString In Class
    """
    def __init__(self):
        self.result = 0;

    def add(self, num):
        """
        DocString In Method
        """
        self.result += num
        return self.result

def test():
    pass

for a in Calculator:
    pass
