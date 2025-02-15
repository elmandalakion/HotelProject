
const backend = process.env.REACT_APP_BACKEND_URL + "reservation/"

export const getReservations = async () => {
    try {
        const response = await fetch(`${backend}`);
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        const data = await response.json();
        return data
    } catch (error) {
        console.error("Error fetching data:", error);
    }
};

export const getReservation = async (id) => {
    try {
        const response = await fetch(`${backend}${id}`);
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        const data = await response.json();
        return data
    } catch (error) {
        console.error("Error fetching data:", error);
    }
};


export const addReservation = async (reservationDetails) => {
    try {
        const response = await fetch(`${backend}`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(reservationDetails), 
        });

        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }

        return response
    } catch (error) {
        console.error("Error sending data:", error);
    }
};

export const updateReservationInfo = async (id, updatedData) => {
    try {
        const response = await fetch(`${backend}${id}`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(updatedData),
        });

        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }

        
    } catch (error) {
        console.error("Error updating data:", error);
    }
};

export const deleteReservation = async (id) => {
    try {
        const response = await fetch(`${backend}${id}`, {
            method: "DELETE",
        });

        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }

        const data = await response.json();
    } catch (error) {
        console.error("Error deleting data:", error);
    }
};