class Solution:
    def reachingPoints(self, sx, sy, tx, ty):
        """
        :type sx: int
        :type sy: int
        :type tx: int
        :type ty: int
        :rtype: bool
        """
        while tx > sx and ty > sy:
            if tx > ty:
                tx = tx % ty
            else:
                ty = ty % tx

        if tx == sx:
            return (ty - sy) % sx == 0
        if ty == sy:
            return (tx - sx) % sy == 0
        return False