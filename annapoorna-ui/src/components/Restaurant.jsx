
import React from 'react';

const Restaurant = ({ restaurant }) => {
    return (
        <div className="bg-white rounded-xl shadow-md relative">
            <div className="p-4">
                <div className="mb-6">
                    <h3 className="text-xl font-bold">{restaurant.name}</h3>
                </div>
                <img src={restaurant.cloudinaryImageId} alt={restaurant.name} className="w-full h-48 object-cover mb-4 rounded-lg shadow-lg" />
                <div className="text-gray-600 mb-5">{restaurant.description}</div>
                <div className="text-indigo-500 mb-2">{restaurant.location}</div>
            </div>
        </div>
    );
};

export default Restaurant;