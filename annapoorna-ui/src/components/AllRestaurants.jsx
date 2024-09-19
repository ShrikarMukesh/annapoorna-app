// src/components/AllRestaurants.jsx
import React from 'react';
import Restaurant from './Restaurant';
import restaurants from '/restaurants.json';

const AllRestaurants = () => {
    return (
        <div>
            <section className="bg-blue-50 px-4 py-10">
                <div className="container-xl lg:container m-auto">
                    <h2 className="text-3xl font-bold text-indigo-500 mb-6 text-center">
                        Restaurants with Online Food Delivery in Bangalore
                    </h2>
                    <div className="grid grid-cols-1 md:grid-cols-3 gap-6">
                        {restaurants.map((restaurant) => (
                            <Restaurant key={restaurant.id} restaurant={restaurant} />
                        ))}
                    </div>
                </div>
            </section>
        </div>
    );
};

export default AllRestaurants;