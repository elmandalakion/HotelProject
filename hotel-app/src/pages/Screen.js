import { getHotels, addHotel } from '../services/hotel-service';
import { getRooms } from '../services/room-service';
import { getReservations } from '../services/reservation-service';
import { getGuestList } from '../services/guest-service';
import './Screen.css';
import { useEffect, useState } from 'react';
import AddTable from '../components/AddTable';

export default function Screen({selected}) {

    const fields = {
        "hotel": [
            {
                name: "Name",
                value: "hotel_name",
                type: "string",
                action: "fill"
            },
            {
                name: "Address",
                value: "hotel_address",
                type: "string",
                action: "fill"
            },
            {
                name: "Rooms",
                value: "number_of_rooms",
                type: "string",
                action: "fill"
            },
            {
                name: "Accomodations",
                value: "accomodations",
                type: "string",
                action: "check"
            }
        ],
        "room": [
            {
                name: "Hotel",
                type: "string",
                action: "select"
            },
            {
                name: "Floor",
                type: "number",
                action: "fill"
            },
            {
                name: "Number",
                type: "number",
                action: "fill"
            },
            {
                name: "Cost",
                type: "number",
                action: "fill"
            },
        ],
        "guest": [
            {
                name: "Full Name",
                type: "string",
                action: "fill"
            },
            {
                name: "Physical ID",
                type: "string",
                action: "fill"
            },
            {
                name: "Hotel",
                type: "string",
                action: "select"
            },
            {
                name: "Room",
                type: "number",
                action: "select"
            },
            {
                name: "Check In Date",
                type: "string",
                action: "fill"
            },
            {
                name: "Check Out Date",
                type: "string",
                action: "fill"
            },
        ],
        "reservation": [
            {
                name: "Full Name",
                type: "string",
                action: "fill"
            },
            {
                name: "Hotel",
                type: "string",
                action: "select"
            },
            {
                name: "Room",
                type: "number",
                action: "select"
            },
            {
                name: "Check In Date",
                type: "string",
                action: "fill"
            },
            {
                name: "Check Out Date",
                type: "string",
                action: "fill"
            },
        ]
    }

    const selection = {
        "hotel": {
            'title': "Hotels",
            'getAll': () => getHotels(),
            'post': "hotel",
            'addTable': <AddTable title={"Add new Hotel!"} fields={fields.hotel} list={["Pool", "Gym", "Breakfast", "Dinner", "Sauna"]}
             post={() => addHotel()} closeTable={() => {setTableOpen(false)}} />
        },
        // "room": {
        //     'title': "Rooms",
        //     'getAll': getRooms(),
        //     'addTable': <AddTable title={"Add new Room!"} fields={fields.room} closeTable={() => {setTableOpen(false)}} />
        // },
        // "reservation": {
        //     'title': "Reservations",
        //     'getAll': getReservations(),
        //     'addTable': <AddTable title={"Make new Reservation!"} fields={fields.reservation} closeTable={() => {setTableOpen(false)}} />
        // },
        // "guest": {
        //     'title': "Guests",
        //     'getAll': getGuestList(),
        //     'addTable': <AddTable title={"Add new Guest!"} fields={fields.guest} closeTable={() => {setTableOpen(false)}} />
        // },
        
    }

    const [content, setContent] = useState([{}])
    const [found, setFound] = useState(false)
    const [isTableOpen, setTableOpen] = useState(false)

    useEffect(() => {

        getContent()

    }, [])

    const getContent = async () => {
        try {
            const selectionContent = await selection[selected].getAll
            if (selectionContent.length){
                setContent(selectionContent)
                setFound(true)
            }
        }
        catch {
        //displayError
        }
    }

    return (
        <main>
            {isTableOpen && selection[selected].addTable}
            <p className='title'>{selection[selected].title}</p>
            <div className='controlPanel'>
                <button onClick={() => {setTableOpen(true)}}>+</button>
                <button>%</button>
            </div>
            {found ?
                    <div>
                        <p>HotelName</p>
                    </div>
                :
                    <p>No {selection[selected].title} Yet</p>
            }
        </main>
    );
}