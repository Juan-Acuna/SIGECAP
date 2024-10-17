#!/bin/bash

until $(curl --output /dev/null --silent --head --fail http://kibana:5601); do
    echo "Esperando a que Kibana esté listo..."
    sleep 5
done
curl -X POST "http://kibana:5601/api/saved_objects/_import?overwrite=true" \
    -H "kbn-xsrf: true" \
    --form file=@/usr/share/filebeat/objects.ndjson
echo "Importación de objetos guardados completada."
