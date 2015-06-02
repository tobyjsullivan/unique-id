# Unique ID Service

A simple service to return unique IDs.

## Work in progress

* IDs are not persisted

## Usage

### POST /ids/:idKey

Send a POST request to this endpoint followed by any string to act as your ID key thereafter. The initial request will
return an id value of 1. Each subsequent request will increment the value.

_Response_

```json
{
  "result": 3
}
```

