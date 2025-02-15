import { useEffect, useRef } from 'react';
import './AddTable.css'
import { addHotel } from '../services/hotel-service';

export default function AddTable({title, fields, list, post, closeTable}) {

  const formRef = useRef();

  useEffect(() => {
  }, [])

  const postItem = async () => {

    var allGood = true
    var item = {}
    fields.forEach((field) => {
      if (field.action === "fill"){
        const text = document.querySelector(`input[name="${field.name}"]`).value;
        if (!text.length) 
          allGood = false
        else
          item = {...item, [field["value"]]: text }
      }
      else if (field.action === "select"){
        const radio = document.querySelector(`input[name="${field.name}"]:checked`).value;
        if (!radio) 
          allGood = false
        else
          item = {...item, [field["value"]]: radio }
      }
      else if (field.action === "check"){
        const checkedCheckboxes = formRef.current.querySelectorAll(
          'input[type="checkbox"]:checked'
        );
    
        const checks = Array.from(checkedCheckboxes).map((checkbox) => checkbox.value);
    
        checks.forEach((check) => {
          item = {...item, [field["value"]]: check }
        })
      }
    })
    
    if (allGood){
      var response
      if (post==="hotel")
        response = await addHotel(item)
      console.log(response)
    }
    else 
      alert("Please, fill in all fields!");
      
  }

  const getFields = (field, index) => {
    if (field.action === "fill") {
      return (
        <div className='form-input'>
            <label style={{width: "200px"}} for={field.name}>{field.name}</label>
            <input type="text" id={field.name} name={field.name} />
          </div>
      )
    }
    else if (field.action === "select") {
     return( <div className='form-input'>
            <p>{field.name}</p>
            <div className='radios'>
              {list && list.map((item) => (
                <div>
                  <label className='radio-label' for={item}>{item}</label>
                  <input className='radio-button' type="radio" id={item} name={field.name} value={item} />
                </div>
              ))}
            </div>
          </div>)
    }
    else if (field.action === "check") {
      return (<div className='form-input'>
            <p>{field.name}</p>
            <div className='radios'>
              {list && list.map((item) => (
                <div>
                  <label className='radio-label' for={item}>{item}</label>
                  <input className='radio-button' type="checkbox" id={item} name={field.name} value={item} />
                </div>
              ))}
            </div>
          </div>)
    }
  }

  return (
    <section ref={formRef}>
      <button className='close-x' onClick={closeTable}>x</button>
      <p className='title'>{title}</p>
      {fields && fields.map((field, index) => (
        getFields(field, index)
      ))}
      <button className='submit-button' onClick={() => postItem()}>Create</button>
    </section>
  );
}
