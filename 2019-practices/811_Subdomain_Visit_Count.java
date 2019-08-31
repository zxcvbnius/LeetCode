class Solution(object):
    def subdomainVisits(self, cpdomains):
        """
        :type cpdomains: List[str]
        :rtype: List[str]
        """
        counter = {} # key: domain, value: count
        for cpdomain in cpdomains:
            count, domain = cpdomain.split(" ")
            subdomain = ''

            domains = domain.split('.')
            domains.reverse()
            for name in domains:
                if not subdomain:
                    subdomain = name
                else: 
                    subdomain = name + '.' + subdomain

                if not counter.get( subdomain ):
                    counter[subdomain] = int(count)
                else:
                    counter[subdomain] += int(count)
        
        res = [ str(v) + ' ' + k for k, v in counter.items() ]
        return res 
