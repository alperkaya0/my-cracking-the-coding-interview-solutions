def URLify(s, l):
    s = s.rstrip()
    lst = []
    for c in s:
        lst.append("%20" if c == " "  else c)
    r = ''.join(lst)
    return r

print(URLify("Mr John Smith    ", 13))