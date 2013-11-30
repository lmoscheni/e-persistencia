from pycassa import *
from pickle import *
import random

class Connection_DB:
	
	def __init__(self , pol , col):
		self.pool = ConnectionPool(pol)
		self.column = ColumnFamily(self.pool , col)

	#Este metodo se debe redefinir para cada clase en particular
	def save(self , user):
		self.column.insert(user.get_name(),{	'name': user.get_name(),
												'pictures': dumps([]),
												'friends': dumps([]),
												'lost' : str(random.randrange(10)),
												'won' : str(random.randrange(10)),
												'draw' : str(random.randrange(10))
								 		   })

	#Este metodo, asocia (key -> an_object), a la vez an_Object es parte "de un tipo
	# de columna dado"
	def put_in_the_column(self , key , column_name , an_object , serializable=False):
		element = None
		if(serializable):
			element = dumps(an_object)
		else:
			element = an_object

		self.column.insert(key , {column_name : element})

	#Este metodo dado un key, te retorna el valor asociado para ese key, en una
	#columna determinada
	def get_column(self , key , an_column , serializable=False):
		element = None
		if(serializable):
			element = loads(self.column.get(key)[an_column])
		else:
			element = self.column.get(key)[an_column]

		return element


	#Este metodo borra todos los datos de la BD
	def resetBD():
		self.column.truncate()


class User:
	db_connection = Connection_DB("pugpe","encontroxvi")
	
	def __init__(self, name, email):
		self.name = name
		self.email = email
		#Persistir datos en DB
		self.db_connection.save(self)
	
	'''
			Getters
	'''
	def get_name(self):
		return self.name

	def get_email(self):
		return self.email

	def get_pictures(self):
		return (self.db_connection.get_column(self.get_name() , 'pictures' , True))

	def get_friends(self):
		return (self.db_connection.get_column(self.get_name() , 'friends' , True))

	def get_games_lost(self):
		return (self.db_connection.get_column(self.get_name() , 'lost'))

	def get_games_won(self):
		return (self.db_connection.get_column(self.get_name() , 'won'))

	def get_games_draw(self):
		return (self.db_connection.get_column(self.get_name() , 'draw'))

	
	'''
			Setters
	'''
	def set_pictures(self, ls):
		self.db_connection.put_in_the_column(self.get_name() ,'pictures' , ls , True)

	def set_friends(self, ls):
		self.db_connection.put_in_the_column(self.get_name() ,'friends' , ls , True)

	
	'''
			Funciones para poder visualizar la en consola la lista de amigos y fotos
	'''
	def print_friends(self):
		return (pass_to_name(self.db_connection.get_column(self.get_name() , 'friends' , True)))

	def print_pictures(self):
		return (pass_to_name(self.db_connection.get_column(self.get_name() , 'pictures' , True)))

	'''
			Funciones de Negocio
	'''

	# Explicacion:
	# supongamos que tenemos a los usuarios A, B, C, D y E
	# A tiene una lista de amigos que es [B, C]
	# B tiene una lista de amigos que es [D]
	# D tiene una lista de amigos que es [E]
	# C tiene una lista de amigos []
	# si hacemos:
	# A.get_friends_level_3() esta nos retornara: [B,C,D,E] -> tiene 3 niveles de anidamiento
	# B.get_friends_level_3() esta nos retornara: [D,E] -> tiene 2 niveles de anidamiento
	# La funcion como maximo trae hasta tres niveles de anidamiento, en caso de que lo haya.
	def get_friends_level_3(self):
		resulset = []
		first_Level_List = self.get_friends()
		resulset.extend(first_Level_List)
		second_Level_List= self._get_friends_to_list(first_Level_List)
		resulset.extend(second_Level_List)
		three_Level_List = self._get_friends_to_list(second_Level_List)
		resulset.extend(three_Level_List)
		return resulset


	# Esta funcion dada una lista de amigos, retorna la lista conformada por
	# los amigos de mis amigos.
	def _get_friends_to_list(self, ls):
		resulset = []
		for x in ls:
			resulset.extend(x.get_friends())

		return resulset


'''
		FUNCIONES HELPER
'''
# Funcion que ~serializacion() sobre los elementro de una lista
def pass_to_name(ls):
	ret = []
	for e in ls:
		ret.append(e.get_name())
	return ret



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

'''
		MAIN : Corriendo la BD
'''
# Definicion de 8 usuarios
user = User("Leandro" , "pepepitopapo")
user1 = User('Bequita' , '')
user2 = User('Julian' , '')
user3 = User('Jona' , '')
user4 = User("Putito", "")
user5 = User("Gil" , "")
user6 = User("Mierdita" , "")
user7 = User("Popo" , "")
user8 = User("Mengano", "")
user9 = User("Cosme", "")
user10 = User("Gaston", "")
user11 = User("Hask", "")

# agregamos al usuario "user" tres amigos user1,user2 y user3
xs = [user1, user2, user3]
user.set_friends(xs)

# agregamos al usuario "user1" dos amigos user4 y uset 5
ys = [user4, user5]
user1.set_friends(ys)

# agregamos al usuario "user6" como amigo de "user5" 
zs = [user6]
user5.set_friends(zs)

# agregamos al usuario "user7" como amigo del usuario "user6"
t = [user7]
user6.set_friends(t)

print(pass_to_name(user.get_friends_level_3()))

#Iniciamos el sistema de promedios
syst = System()
list_user = [user, user1, user2, user3, user4, user5, user7, user8, user9, user10, user11]

#Guardamos la lista de los 10 mejores en el sistema.
for u in list_user:
	syst.add_user(u)
syst.update_cache()

print(pass_to_name(syst.get_top_ten_users()))

syst.add_user(User("Diego", ""))

syst.update_cache()
print(pass_to_name(syst.get_top_ten_users()))