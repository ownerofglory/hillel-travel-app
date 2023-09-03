# Hillel Travel App

![](https://github.com/ownerofglory/hillel-travel-app/actions/workflows/github-actions.yml/badge.svg)

## Overview
The “Hillel Travel App” is an application where users can document and share their travel experiences. They can mark locations on a map, upload photos, write notes, and share with friends or the public.


The Java backend will manage user profiles, entries, and shared journals. Mapbox (or a similar service) will be used to allow users to pin locations and visualize their travel paths.

## Features
- User Profiles: Register and manage personal profiles.
- Travel Entries: Add new travel experiences with photos, notes, and marked locations on the map.
- Interactive Map: Using Mapbox, allow users to pin their traveled locations and see travel paths.
- Social Sharing: Users can choose to share their entries with friends or the public.
- Search & Explore: Users can explore public entries of other travelers, search for specific locations, and gain inspiration for future travels.
- Comments & Likes: Engage with the community by leaving comments and likes on shared journals.

## Architecture overview
Application implements a full-stack app architecture with separate frontend and backend parts

![architecture](./docs/architecture.png)

Frontend can be a webapp, a desktop client or a mobile application

Backend is a monolith Java Application that communicates with a MySQL database, object storage and 3rd-party API

### Backend Entities
- `User` represents actual users that use the app
- `TravelEntry` represents a trip. User can have multiple trips
- `Location` represents a location that belongs to certain trip (`TravelEntry`)
- `Comment` - represents a comment given by a user to a trip (`TravelEntry`)
- `Like` - represents a like given by a user to a trip (`TravelEntry`)
![entities](./docs/entities.png)

### Entity class diagram
Class diagram that represents entities and relationships between them
![entity-class-diagram](./docs/entity-class-diagram.png)

### MySQL Schema
![dbschema](./docs/db-schema.png)

### Backend Layers
Backend consists of 3 layers:
- Controller (API, Resources, ...)
- Business Logic (Services)
- Data access (Repo, DAO, ...)
![backendlayers](./docs/backend_layers.png)

### Backend Domains
![backendlayersdomain](./docs/backend-layers-domain.png)

### Backend Layers detailed
![backendlayersdeps](./docs/backend_layers_deps.png)

### Backend data flow
![backenddataflow](./docs/backend_data_flow.png)

<style>
    img[alt=architecture] {
        width: 600px;
    }

    img[alt=entities] {
        width: 400px;
    }

    img[alt='entity-class-diagram'] {
        width: 400px;
    }

    img[alt='dbschema'] {
        width: 720px;
    }

    img[alt='backendlayers'] {
        width: 400px;
    }

    img[alt='backendlayersdomain'] {
        width: 480px;
    }

    img[alt='backendlayersdeps'] {
        width: 480px;
    }

    img[alt='backenddataflow'] {
        width: 480px;
    }
</style>