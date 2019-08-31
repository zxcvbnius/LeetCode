class Solution(object):
    def defangIPaddr(self, address):
        """
        :type address: str
        :rtype: str
        """
        res = address.split('.')
        return '[.]'.join(res)
        
