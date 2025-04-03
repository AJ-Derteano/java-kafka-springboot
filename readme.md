# Instrucciones finales para probar la aplicación Kafka

# 1. Detener todos los contenedores
docker-compose down -v

# 2. Asegurarse de eliminar los volúmenes y redes antiguos
> Tener encuenta que eliminara todos lo que no este en uso
docker system prune -f
docker volume prune -f

# 3. Levantar todos los servicios
docker-compose up -d

# 4. Esperar a que todos los servicios estén activos (importante!)
# Verificar el estado con:
docker-compose ps

# 5. Para enviar mensajes:
```sh
# Enviar y listar boletas
curl  -X POST \
  'http://localhost:8081/boleta/enviar' \
  --header 'Accept: */*' \
  --header 'User-Agent: Thunder Client (https://www.thunderclient.com)' \
  --header 'Content-Type: application/json' \
  --data-raw '{
  "numeroBoleta": "#123456789",
  "cliente": "Pepe Lucho",
  "monto": 90.99,
  "fecha": "2025-04-01"
'

curl  -X GET \
  'http://localhost:8081/boleta/listar' \
  --header 'Accept: */*' \
  --header 'User-Agent: Thunder Client (https://www.thunderclient.com)'
}
```
```sh
# Enviar y listas pedidos
curl  -X POST \
  'http://localhost:8081/pedidos/enviar' \
  --header 'Accept: */*' \
  --header 'User-Agent: Thunder Client (https://www.thunderclient.com)' \
  --header 'Content-Type: application/json' \
  --data-raw '{
  "numeroPedido": "#123456789",
  "cliente": "Pepe Lucho",
  "fecha": "2025-04-01",
  "productos": ["Producto 1", "Producto 2", "Producto 3"],
  "total": 99.99
}
'

curl  -X GET \
  'http://localhost:8081/boleta/listar' \
  --header 'Accept: */*' \
  --header 'User-Agent: Thunder Client (https://www.thunderclient.com)'
```

# 6. Para ver la interfaz gráfica de Kafka:
# Abre en el navegador: http://localhost:8080

# 8. Al terminar, para detener todos los servicios:
docker-compose down