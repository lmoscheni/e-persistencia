class System:

	def __init__(self):
		self.pool_cache = ConnectionPool("AverageMatches")
		self.column_cache = ColumnFamily(self.pool_cache , "Average")
		self.users = []
		self.cache_status = []

	def add_user( self , user):
		self.users.append(user)

	def remove_user(self, user):
		self.users.remove(user)

	def get_users(self):
		return self.users

	def get_top_ten_users(self):
		return self.cache_status

	def update_cache(self):
		self.column_cache.truncate()
		index = 0
		for u in self._generate_cache():
			self.column_cache.insert( str(index + 1) , {
														'user' : u.get_name() ,
														'lost' : u.get_games_lost() ,
														'won' : u.get_games_won() ,
														'draw' : u.get_games_draw()
													})

	def _generate_cache(self):
		xs = []
		xs.extend(self.users)
		ys = []
		for u in range(0,10):
			ys.append(self.top_winning_user(xs))

		self.cache_status = ys
		return ys

	def top_winning_user(self , lss):
		ls = lss
		element = ls[0]
		for x in ls:
			if(x.get_games_won() > element.get_games_won()):
				element = x
		ls.remove(element)
		return element