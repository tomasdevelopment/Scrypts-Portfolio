#import relevant libraries
import numpy as np
import matplotlib.pyplot as plt
from gapminder import gapminder
#Filtrar solo para 2007 la base de datos
gapminder_2007 = gapminder[gapminder["year"]==2007]
gapminder_2007.reset_index(drop=True, inplace = True)
gapminder_2007.head()

#Definir colores del grafico  de disprecion
gapminder_2007['col'] = ""
for i in range(142):
    if gapminder_2007['continent'][i] == 'Africa':
        gapminder_2007['col'][i] = 'blue'
    elif gapminder_2007['continent'][i] == 'Europe':
        gapminder_2007['col'][i] = 'green'
    elif gapminder_2007['continent'][i] == 'Asia':
        gapminder_2007['col'][i] = 'red'
    elif gapminder_2007['continent'][i] == 'Americas':
        gapminder_2007['col'][i] = 'yellow'
    elif gapminder_2007['continent'][i] == 'Oceania':
        gapminder_2007['col'][i] = 'black'


#Grafico de dispercion detalles
#definir variable poblacion y se divide para  ajustar a los ejes definidos
pop = gapminder_2007['pop'] / 1000000
#creamos un array de NUmply basados en esta variable
np_pop = np.array(pop)
np_pop = np_pop*2
#Se espefican colores por continente
col = gapminder_2007['col']
gdp_cap = gapminder_2007["gdpPercap"]
life_exp = gapminder_2007["lifeExp"]
plt.scatter(gdp_cap, life_exp, s = np_pop , c = col, alpha = 0.8)
plt.xscale('log')
##incdicamos texto que se mostrara en grafica
xlab = 'PIB per Capita en USD'
ylab = 'Expectativa de vida en A;os'
title = 'Desarollo Mundial 2007'
plt.xlabel(xlab)
plt.ylabel(ylab)
plt.title(title)
##se definend ticks para mejorrar escala
tick_val = [1000,10000,100000]
tick_lab  = ['1k','10k','100k']
plt.xticks(tick_val,tick_lab)
##Darle name a algunos puntos
plt.text(5700,80,'China')
#Agregar rejilla
plt.grid(True)

plt.show()
