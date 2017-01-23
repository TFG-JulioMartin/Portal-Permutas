import {
  Component,
  OnInit
} from '@angular/core';


@Component({
  moduleId:	module.id,
  selector: 'g-map',
  styles: [`
    .sebm-google-map-container {
       height: 600px;
     }
  `],
  template: `
  	<div class="container">
    <sebm-google-map 
      [latitude]="lat"
      [longitude]="lng"
      [zoom]="zoom"
      [disableDefaultUI]="false"
      [zoomControl]="false"
      (mapClick)="mapClicked($event)">
    
      <sebm-google-map-marker 
          *ngFor="let m of markers; let i = index"
          (markerClick)="clickedMarker(m.label, i)"
          [latitude]="m.lat"
          [longitude]="m.lng"
          [label]="m.label"
          [markerDraggable]="m.draggable"
          (dragEnd)="markerDragEnd(m, $event)">
          
        <sebm-google-map-info-window>
          <strong>InfoWindow content</strong>
        </sebm-google-map-info-window>
        
      </sebm-google-map-marker>
      
      <sebm-google-map-circle [latitude]="lat" [longitude]="lng" 
          [radius]="300"
          [fillColor]="'red'"
          [circleDraggable]="true"
          [editable]="true">
      </sebm-google-map-circle>

    </sebm-google-map>
    </div>
`})
export class MapComponent {
  // google maps zoom level
  
   ngOnInit(): void {}
  zoom: number = 13;
  
  // initial center position for the map
  lat: number = 37.362444;
  lng: number = -5.9965;
  
  clickedMarker(label: string, index: number) {
    console.log(`clicked the marker: ${label || index}`)
  }
  
  mapClicked($event: MouseEvent) {
    this.markers.push({
      lat: $event.coords.lat,
      lng: $event.coords.lng
    });
  }
  
  markerDragEnd(m: marker, $event: MouseEvent) {
    console.log('dragEnd', m, $event);
  }
  
  markers: marker[] = [
	  {
		  lat: 37.382444,
		  lng: -5.99625,
		  label: 'A',
		  draggable: true
	  },
	  {
		  lat: 	37.3541545,
		  lng: -5.9885772,
		  label: 'A',
		  draggable: true
	  }
  ]
}
// just an interface for type safety.
interface marker {
	lat: number;
	lng: number;
	label?: string;
	draggable: boolean;
}