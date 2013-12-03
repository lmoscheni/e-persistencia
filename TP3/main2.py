from helper import *
from system import *
from connectionDB import *
from user import *

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